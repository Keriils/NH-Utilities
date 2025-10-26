plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("online.keriils.plugins.spotless-wrapper") version "0.1.5"
    /// Convention over Configuration!!!
    /// 打包了 elytra-convention 的轮子拓展了依赖声明(更加轮椅化haa..)
    /// elytra-convention url: https://github.com/ElytraServers/elytra-conventions/
    id("online.keriils.plugins.dependency-declaration-convention") version "0.1.5"
}

wrapperSpotless {
    alwaysApplySpotless = false
    enforceSpotlessCheck = false
    enforceSpotlessCheckForCIEnv = true
}

dependencies {
    dependencyDeclarations {
        gtnhVersion = "2.8.0"

        declarationApi {
            declare("GT5-Unofficial")
            declare("NewHorizonsCoreMod")
            declare("Baubles-Expanded")
            declare("ae2stuff")
        }

        declarationImplementation {
            declare("Avaritiaddons")
            declare("Eternal-Singularity")
            declare("Universal-Singularities")
            declare("WarpTheory")
            declare("Mobs-Info")
            declare("Jabba") { isTransitive = false }
            declare("ThaumicTinkerer") { isTransitive = false }
            declare("EnderIO") { isTransitive = false }
            declare("EnderCore") { isTransitive = false }
            declare("BrandonsCore") { isTransitive = false }
            declare("Draconic-Evolution") { isTransitive = false }
            declare("Botania") { isTransitive = false }
            declare("Avaritia") { isTransitive = false }
            declare("SpiceOfLife") { isTransitive = false }
            declare("AppleCore") { isTransitive = false }
            declare("InventoryBogoSorter")

            implementation(rfg.deobf("curse.maven:extra-utilities-225561:2264384"))
            implementation("com.github.GTNewHorizons:worldedit-gtnh:v0.0.8:dev") { isTransitive = false }
        }

        declarationCompileOnly {
            compileOnly("org.projectlombok:lombok:1.18.42")
            annotationProcessor("org.projectlombok:lombok:1.18.42")
        }

        declarationRuntimeOnlyNonPublishable {
            declare("ServerUtilities") { isTransitive = false }
            declare("Angelica") { isTransitive = false }
            declare("BlockRenderer6343") { isTransitive = false }
            declare("Galacticraft") { isTransitive = false }
        }

        configurations.forEach { it.exclude("com.github.GTNewHorizons", "Baubles") }
    }
}

val isCiEnvironment = System.getenv("CI") == "true" || System.getenv("GITHUB_ACTIONS") == "true"

// 为 runClient 和 runServer 配置不同的目录
// 默认是允许的 但是我还是添加了配置 "nhu.runPathIsolation" 去调节
listOf(tasks.runClient, tasks.runServer, tasks.runClient17, tasks.runServer17, tasks.runClient21, tasks.runServer21)
    .forEach {
        if (properties["nhu.runPathIsolation"] == "false" || isCiEnvironment) return@forEach
        it.configure {
            // spotless:off
            workingDir =
                // runClient[17/21] -> run/client
                // runServer[17/21] -> run/server
                file(
                    it.name
                        .replace(Regex("\\d+$"), "")
                        .split(Regex("(?=[A-Z])"))
                        .joinToString("/") { s -> s.lowercase() }
                )
            // spotless:on
        }
    }

// 依赖声明相关内容 放最底下.....
/*
 * Add your dependencies here. Supported configurations:
 *  - api("group:name:version:classifier"): if you use the types from this dependency in the public API of this mod
 *       Available at runtime and compiletime for mods depending on this mod
 *  - implementation("g:n:v:c"): if you need this for internal implementation details of the mod, but none of it is visible via the public API
 *       Available at runtime but not compiletime for mods depending on this mod
 *  - compileOnly("g:n:v:c"): if the mod you're building doesn't need this dependency during runtime at all, e.g. for optional mods
 *       Not available at all for mods depending on this mod, only visible at compiletime for this mod
 *  - compileOnlyApi("g:n:v:c"): like compileOnly, but also visible at compiletime for mods depending on this mod
 *       Available at compiletime but not runtime for mods depending on this mod
 *  - runtimeOnlyNonPublishable("g:n:v:c"): if you want to include a mod in this mod's runClient/runServer runs, but not publish it as a dependency
 *       Not available at all for mods depending on this mod, only visible at runtime for this mod
 *  - devOnlyNonPublishable("g:n:v:c"): a combination of runtimeOnlyNonPublishable and compileOnly for dependencies present at both compiletime and runtime,
 *       but not published as Maven dependencies - useful for RFG-deobfuscated dependencies or local testing
 *  - runtimeOnly("g:n:v:c"): if you don't need this at compile time, but want it to be present at runtime
 *       Available at runtime for mods depending on this mod
 *  - annotationProcessor("g:n:v:c"): mostly for java compiler plugins, if you know you need this, use it, otherwise don't worry
 *  - testCONFIG("g:n:v:c") - replace CONFIG by one of the above (except api), same as above but for the test sources instead of main
 *
 *  - shadowImplementation("g:n:v:c"): effectively the same as API, but the dependency is included in your jar under a renamed package name
 *       Requires you to enable usesShadowedDependencies in gradle.properties
 *
 *  - compile("g:n:v:c"): deprecated, replace with "api" (works like the old "compile") or "implementation" (can be more efficient)
 *
 * You can exclude transitive dependencies (dependencies of the chosen dependency) by appending { transitive = false } if needed,
 * but use this sparingly as it can break using your mod as another mod's dependency if you're not careful.
 *
 * To depend on obfuscated jars you can use `devOnlyNonPublishable(rfg.deobf("dep:spec:1.2.3"))` to fetch an obfuscated jar from maven,
 * or `devOnlyNonPublishable(rfg.deobf(project.files("libs/my-mod-jar.jar")))` to use a file.
 *
 * Gradle names for some of the configuration can be misleading, compileOnlyApi and runtimeOnly both get published as dependencies in Maven, but compileOnly does not.
 * The buildscript adds runtimeOnlyNonPublishable to also have a runtime dependency that's not published.
 *
 * For more details, see https://docs.gradle.org/8.0.1/userguide/java_library_plugin.html#sec:java_library_configurations_graph
 */
