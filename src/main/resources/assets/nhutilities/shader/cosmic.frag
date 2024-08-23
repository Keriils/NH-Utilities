#version 120

#define M_PI 3.1415926535897932384626433832795

const int cosmiccount = 10;
const int cosmicoutof = 101;

uniform sampler2D texture0;
uniform vec3 lightlevel;

uniform float time2;

uniform float yaw;
uniform float pitch;
uniform float externalScale;

uniform float lightmix;
uniform float opacity;

uniform mat2 cosmicuvs[cosmiccount];

varying vec3 position;

float rand2d(vec2 x) {
    return fract(sin(mod(dot(x, vec2(12.9898, 78.233)), 3.14)) * 43758.5453);
}

mat4 rotationMatrix(vec3 axis, float angle)
{

    axis = normalize(axis);
    float s = sin(angle);
    float c = cos(angle);
    float oc = 1.0 - c;

    return mat4(oc * axis.x * axis.x + c,           oc * axis.x * axis.y - axis.z * s,  oc * axis.z * axis.x + axis.y * s,  0.0,
                oc * axis.x * axis.y + axis.z * s,  oc * axis.y * axis.y + c,           oc * axis.y * axis.z - axis.x * s,  0.0,
                oc * axis.z * axis.x - axis.y * s,  oc * axis.y * axis.z + axis.x * s,  oc * axis.z * axis.z + c,           0.0,
                0.0,                                0.0,                                0.0,                                1.0);
}

void main (void)
{
    vec4 light = gl_Color;
    vec4 mask = texture2D(texture0, gl_TexCoord[0].xy);
    light.rgb *= lightlevel;
    float correctTime = mod(time2,12000);

    float oneOverExternalScale = 1.0/externalScale;

    int uvtiles = 16;

    // background colour
    vec4 col = vec4(0.1,0.0,0.0,1.0);

    float pulse = mod(correctTime,400)/400.0;

    col.g = sin(pulse*M_PI*2) * 0.075 + 0.225;
    col.b = cos(pulse*M_PI*2) * 0.05 + 0.3;

    // get ray from camera to fragment
    vec4 dir = normalize(vec4( -position, 0));

	// rotate the ray to show the right bit of the sphere for the angle
	float sb = sin(pitch);
	float cb = cos(pitch);
	dir = normalize(vec4(dir.x, dir.y * cb - dir.z * sb, dir.y * sb + dir.z * cb, 0));

	float sa = sin(-yaw);
	float ca = cos(-yaw);
	dir = normalize(vec4(dir.z * sa + dir.x * ca, dir.y, dir.z * ca - dir.x * sa, 0));

	vec4 ray;

	// draw the layers
	for (int i=0; i<16; i++) {
		int mult = 16-i;

		// get semi-random stuff
		int j = i + 7;
		float rand1 = (j * j * 4321 + j * 8) * 2.0;
		int k = j + 1;
		float rand2 = (k * k * k * 239 + k * 37) * 3.6;
		float rand3 = rand1 * 347.4 + rand2 * 63.4;

		// random rotation matrix by random rotation around random axis
		vec3 axis = normalize(vec3(sin(rand1), sin(rand2) , cos(rand3)));

		// apply
		ray = dir * rotationMatrix(axis, mod(rand3, 2*M_PI));

		// calcuate the UVs from the final ray
		float rawu = 0.5 + (atan(ray.z,ray.x)/(2*M_PI));
		float rawv = 0.5 + (asin(ray.y)/M_PI);

		// get UV scaled for layers and offset by time;
		float scale = mult*0.5 + 2.75;
		float u = rawu * scale * externalScale;
		//float v = (rawv + time * 0.00006) * scale * 0.6;
		float v = (rawv + correctTime * 0.0002 * oneOverExternalScale) * scale * 0.6 * externalScale;

		vec2 tex = vec2( u, v );

		// tile position of the current uv
		int tu = int(mod(floor(u*uvtiles),uvtiles));
		int tv = int(mod(floor(v*uvtiles),uvtiles));

		// get pseudorandom variants
		int symbol = int(rand2d(vec2(tu, tv + i * 10.0)) * cosmicoutof);
		int rotation = int(mod(pow(tu,float(tv)) + tu + 3 + tv*i, 8));
		bool flip = false;
		if (rotation >= 4) {
			rotation -= 4;
			flip = true;
		}

		// if it's an icon, then add the colour!
		if (symbol >= 0 && symbol < cosmiccount) {

			vec2 cosmictex = vec2(1.0,1.0);
			vec4 tcol = vec4(1.0,0.0,0.0,1.0);

			// get uv within the tile
			float ru = clamp(mod(u,1.0)*uvtiles - tu, 0.0, 1.0);
			float rv = clamp(mod(v,1.0)*uvtiles - tv, 0.0, 1.0);

			if (flip) {
				ru = 1.0 - ru;
			}

			float oru = ru;
			float orv = rv;

			// rotate uvs if necessary
			if (rotation == 1) {
				oru = 1.0-rv;
				orv = ru;
			} else if (rotation == 2) {
				oru = 1.0-ru;
				orv = 1.0-rv;
			} else if (rotation == 3) {
				oru = rv;
				orv = 1.0-ru;
			}

			// get the iicon uvs for the tile
			float umin = cosmicuvs[symbol][0][0];
			float umax = cosmicuvs[symbol][1][0];
			float vmin = cosmicuvs[symbol][0][1];
			float vmax = cosmicuvs[symbol][1][1];

			// interpolate based on tile uvs
			cosmictex.x = umin * (1.0-oru) + umax * oru;
			cosmictex.y = vmin * (1.0-orv) + vmax * orv;

			tcol = texture2D(texture0, cosmictex);

			// set the alpha, blending out at the bunched ends
			float a = tcol.r * (0.5 + (1.0/mult) * 1.0) * (1.0-smoothstep(0.15, 0.48, abs(rawv-0.5)));

			// get fancy colours
			float r = (mod(rand1, 29.0)/29.0) * 0.3 + 0.4;
	    	float g = (mod(rand2, 35.0)/35.0) * 0.4 + 0.6;
	    	float b = (mod(rand1, 17.0)/17.0) * 0.3 + 0.7;

			// mix the colours
			//col = col*(1-a) + vec4(r,g,b,1)*a;
			col = col + vec4(r,g,b,1)*a;
		}
	}

	// apply lighting
    vec3 shade = light.rgb * (lightmix) + vec3(1.0-lightmix,1.0-lightmix,1.0-lightmix);
    col.rgb *= shade;

    // apply mask
    col.a *= mask.a * opacity;

	col = clamp(col,0.0,1.0);

    gl_FragColor = col;
}
