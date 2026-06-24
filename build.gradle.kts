import com.diffplug.blowdryer.Blowdryer as BlowdryerPlugin
import com.diffplug.gradle.spotless.BaseKotlinExtension
import com.diffplug.gradle.spotless.FormatExtension
import com.diffplug.spotless.kotlin.KtfmtStep
import org.gradle.internal.extensions.stdlib.toDefaultLowerCase
import org.jetbrains.gradle.ext.Gradle as GradleExt
import org.jetbrains.gradle.ext.RunConfigurationContainer
import org.jetbrains.gradle.ext.runConfigurations
import org.jetbrains.gradle.ext.settings

plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("com.diffplug.spotless") version "8.1.0"
    id("com.github.ElytraServers.elytra-conventions") version "v1.1.2"
}

@Suppress("UnusedReceiverParameter")
val Project.isCiEnvironment
    inline get() = System.getenv("CI") == "true" || System.getenv("GITHUB_ACTIONS") == "true"

// region Dependencies

fun gtnhdev(name: String) = elytraModpackVersion.gtnhdev(name)

dependencies {
    elytraModpackVersion.gtnhVersion = "2.9.0-beta-1"

    implementation(gtnhdev("GT5-Unofficial"))
    implementation(gtnhdev("NewHorizonsCoreMod"))
    implementation(gtnhdev("Baubles-Expanded"))

    implementation(rfg.deobf("curse.maven:extra-utilities-225561:2264384"))
    implementation("com.github.GTNewHorizons:worldedit-gtnh:v0.0.8:dev")

    // implementation(gtnhdev("ae2stuff"))
    implementation(gtnhdev("Hodgepodge"))
    implementation(gtnhdev("Avaritiaddons"))
    implementation(gtnhdev("Eternal-Singularity"))
    implementation(gtnhdev("Universal-Singularities"))
    implementation(gtnhdev("WarpTheory"))
    implementation(gtnhdev("Mobs-Info"))
    implementation(gtnhdev("Jabba"))
    // Todo 与巫术相关插件问题较大 2.9.+解决
    implementation(gtnhdev("ThaumicTinkerer")) { isTransitive = false }
    implementation(gtnhdev("EnderIO"))
    implementation(gtnhdev("Draconic-Evolution"))
    implementation(gtnhdev("Botania"))
    implementation(gtnhdev("SpiceOfLife"))
    // Todo 2.8.4左右的构思依赖的附魔和TT神秘冲突 2.9.+解决
    implementation(gtnhdev("InventoryBogoSorter")) { isTransitive = false }

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    // runtimeOnlyNonPublishable(gtnhdev("Angelica"))
    runtimeOnlyNonPublishable(gtnhdev("BlockRenderer6343"))
    runtimeOnlyNonPublishable(gtnhdev("Galacticraft"))
}

// for dependencies AT, ensures that IDE does not show errors
minecraft.useDependencyAccessTransformers = true

configurations.configureEach {
    val gtnhGroup = "com.github.GTNewHorizons"
    exclude(gtnhGroup, "Baubles")

    val blackList = listOf("unimixins", "GTNHLib", "jabel-stubs", "lwjgl3ify", "Hodgepodge")

    // 强制大部分依赖与elytra-conventions插件提供的版本对齐
    resolutionStrategy {
        eachDependency {
            if (target.name in elytraModpackVersion && target.group == gtnhGroup) {
                useVersion(elytraModpackVersion[target.name]!!)
            }
        }
    }
}

// endregion

// region Injected Tags
minecraft {
    val modId = properties["modId"] as? String ?: error("modId is not in properties!")
    val modName = properties["modName"] as? String ?: error("modName is not in properties!")
    injectedTags.put("MOD_ID", modId)
    injectedTags.put("MOD_ID_UPPER", modId.uppercase())
    injectedTags.put("MOD_ID_LOWER", modId.toDefaultLowerCase())
    injectedTags.put("MOD_NAME", modName)
    injectedTags.put("MOD_NAME_UPPER", modName.uppercase())
    injectedTags.put("MOD_NAME_LOWER", modName.toDefaultLowerCase())
    injectedTags.put("RESOURCE_PATH", modName.toDefaultLowerCase() + ":")
}

// endregion

// region Spotless Settings
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

    // todo 2.9.x build-system
    /*
        json {
            // ratchetFrom = "origin/master"
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
    */
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

// endregion
