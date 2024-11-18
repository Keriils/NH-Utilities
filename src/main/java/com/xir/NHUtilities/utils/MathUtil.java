package com.xir.NHUtilities.utils;

import java.util.Random;

@SuppressWarnings("unused")
public class MathUtil {

    private static final Random random = new Random();

    public static float randFloat() {
        return random.nextFloat();
    }

    public static float randFloat(float min, float max) {
        return min + (max - min) * random.nextFloat();
    }

    public static double randDouble() {
        return random.nextDouble();
    }

    public static double nextDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public static int randInt(int bound) {
        return random.nextInt(bound);
    }

    public static int randInt(int origin, int bound) {
        return origin + random.nextInt(bound - origin);
    }

    public static long randLong(long bound) {
        return random.nextLong();
    }

    public static boolean randBoolean() {
        return random.nextBoolean();
    }

    public static double randGaussian() {
        return random.nextGaussian();
    }

    public static String randString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}
