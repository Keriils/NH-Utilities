import cn.elytra.gradle.conventions.extension.ModpackVersionExtension
import com.diffplug.blowdryer.Blowdryer as BlowdryerPlugin
import com.diffplug.gradle.spotless.BaseKotlinExtension
import com.diffplug.gradle.spotless.FormatExtension
import com.diffplug.spotless.kotlin.KtfmtStep
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.jetbrains.gradle.ext.Gradle as GradleExt
import org.jetbrains.gradle.ext.RunConfigurationContainer
import org.jetbrains.gradle.ext.runConfigurations
import org.jetbrains.gradle.ext.settings

plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("com.diffplug.spotless") version "8.1.0"
    id("com.github.ElytraServers.elytra-conventions") version "v1.1.2"
}

val isCiEnvironment = System.getenv("CI") == "true" || System.getenv("GITHUB_ACTIONS") == "true"

elytraModpackVersion {
    gtnhVersion = "2.8.0"
    withGtnhDependencies {
        api {
            configureGtnhDep("GT5-Unofficial")
            configureGtnhDep("NewHorizonsCoreMod")
            configureGtnhDep("Baubles-Expanded")
        }

        implementation {
            configureGtnhDep("ae2stuff")
            configureGtnhDep("Avaritiaddons")
            configureGtnhDep("Eternal-Singularity")
            configureGtnhDep("Universal-Singularities")
            configureGtnhDep("WarpTheory")
            configureGtnhDep("Mobs-Info")
            configureGtnhDep("Jabba") { isTransitive = false }
            configureGtnhDep("ThaumicTinkerer") { isTransitive = false }
            configureGtnhDep("EnderIO") { isTransitive = false }
            configureGtnhDep("EnderCore") { isTransitive = false }
            configureGtnhDep("BrandonsCore") { isTransitive = false }
            configureGtnhDep("Draconic-Evolution") { isTransitive = false }
            configureGtnhDep("Botania") { isTransitive = false }
            configureGtnhDep("Avaritia") { isTransitive = false }
            configureGtnhDep("SpiceOfLife") { isTransitive = false }
            configureGtnhDep("AppleCore") { isTransitive = false }
            configureGtnhDep("InventoryBogoSorter")
        }

        runtimeOnlyNonPublishable {
            configureGtnhDep("Angelica") { isTransitive = false }
            configureGtnhDep("BlockRenderer6343") { isTransitive = false }
            configureGtnhDep("Galacticraft") { isTransitive = false }
        }
    }

    withCommonDependencies {
        implementation(rfg.deobf("curse.maven:extra-utilities-225561:2264384"))
        implementation("com.github.GTNewHorizons:worldedit-gtnh:v0.0.8:dev") { isTransitive = false }

        compileOnly("org.projectlombok:lombok:1.18.42")
        annotationProcessor("org.projectlombok:lombok:1.18.42")
    }

    configurations.forEach { it.exclude("com.github.GTNewHorizons", "Baubles") }

    // Force all standard dependency versions to align with ElytraConvention versions
    configurations.forEach {
        it.resolutionStrategy {
            eachDependency {
                if (target.group == "com.github.GTNewHorizons" && elytraModpackVersion.contains(target.name)) {
                    useVersion(elytraModpackVersion[target.name]!!)
                }
            }
        }
    }
}

idea.project.settings {
    fun RunConfigurationContainer.fastReg(name: String, taskName: String) {
        register<GradleExt>(name) { taskNames = listOf(taskName) }
    }
    runConfigurations {
        fastReg("Apply Spotless", "spotlessApply")
        fastReg("Apply SpotlessCheck", "spotlessCheck")
        fastReg("Clean", "clean")
    }
}

spotless {
    isEnforceCheck = isCiEnvironment

    java {
        target("src/*/java/**/*.java", "src/*/scala/**/*.java")
        formatAnnotations()
        removeUnusedImports()
        applyCommonFormatSteps()
        importOrder("java", "javax", "net", "org", "com")
        eclipse("4.19").configFile(BlowdryerPlugin.file("spotless.eclipseformat.xml"))
    }

    kotlin {
        target("src/*/kotlin/**/*.kt")
        leadingSpacesToTabs()
        applyCustomKtfmtConfig()
        applyCommonFormatSteps()
    }

    kotlinGradle {
        target("*.gradle.kts")
        applyCustomKtfmtConfig()
        applyCommonFormatSteps()
    }

    json {
        ratchetFrom = "origin/master"
        target("src/**/mcmod.info", "src/**/*.json", "src/**/*.mcmeta")
        prettier()
            .config(
                mapOf(
                    "parser" to "json",
                    "printWidth" to 100,
                    "tabWidth" to 2,
                    "objectWrap" to "collapse",
                    "useTabs" to false,
                    "endOfLine" to "lf",
                )
            )
        endWithNewline()
    }
}

private fun BaseKotlinExtension.applyCustomKtfmtConfig() {
    ktfmt("0.61").googleStyle().configure {
        it.setMaxWidth(120)
        it.setBlockIndent(4)
        it.setContinuationIndent(4)
        it.setRemoveUnusedImports(true)
        it.setTrailingCommaManagementStrategy(KtfmtStep.TrailingCommaManagementStrategy.COMPLETE)
    }
}

private fun FormatExtension.applyCommonFormatSteps() {
    toggleOffOn()
    trimTrailingWhitespace()
    endWithNewline()
}

@Suppress("UnusedReceiverParameter")
private inline fun ModpackVersionExtension.withGtnhDependencies(block: ConfigurationContainer.() -> Unit) =
    configurations.block()

@Suppress("UnusedReceiverParameter")
private inline fun ModpackVersionExtension.withCommonDependencies(block: DependencyHandlerScope.() -> Unit) =
    DependencyHandlerScope.of(dependencies).block()

//  其实这里应该进行一定的作用域限制?..
private inline operator fun <T : Any> NamedDomainObjectProvider<T>.invoke(
    block: NamedDomainObjectProvider<T>.() -> Unit
) = block()

private fun <T : Any> NamedDomainObjectProvider<T>.configureGtnhDep(
    name: String,
    classifier: String = "dev",
    dependencyConfiguration: Action<ExternalModuleDependency> = Action {},
): ExternalModuleDependency {
    return addDependencyTo(
        project.dependencies,
        this.name,
        elytraModpackVersion.gtnh(name, classifier),
        dependencyConfiguration,
    )
}

// 为 runClient 和 runServer 配置不同的目录
// 默认是允许的 但是我还是添加了配置 "nhu.runPathIsolation" 去调节
if (properties["nhu.runPathIsolation"] != "false" && !isCiEnvironment) {
    listOf(tasks.runClient, tasks.runServer, tasks.runClient17, tasks.runServer17, tasks.runClient21, tasks.runServer21)
        .forEach {
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
