import com.diffplug.gradle.spotless.BaseKotlinExtension
import com.diffplug.gradle.spotless.FormatExtension

plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("com.diffplug.spotless") version "7.0.2"
}

fun FormatExtension.applyCommonFormatSteps() {
    toggleOffOn()
    trimTrailingWhitespace()
    endWithNewline()
}

@Suppress("SpellCheckingInspection")
fun BaseKotlinExtension.applyCustomKtfmtConfig() {
    ktfmt("0.54").googleStyle().configure {
        it.setMaxWidth(120)
        it.setBlockIndent(4)
        it.setContinuationIndent(4)
        it.setRemoveUnusedImports(true)
        it.setManageTrailingCommas(true)
    }
}

spotless {
    encoding("UTF-8")

    format("misc") {
        target(".gitignore")
        leadingSpacesToTabs()
        applyCommonFormatSteps()
    }

                java {
        target("src/*/java/**/*.java", "src/*/scala/**/*.java")

        formatAnnotations()
        removeUnusedImports()
        applyCommonFormatSteps()
        importOrder("java", "javax", "net", "org", "com")
        eclipse("4.19").configFile(file("SpotlessPlugin/spotless.eclipseFormat.xml"))
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

    groovyGradle {
        target("*.gradle")

        removeSemicolons()
        applyCommonFormatSteps()
        importOrder("java", "javax", "net", "org", "com")
    }
}

tasks.register<Copy>("initGitHooks") {
    val scriptsFile = File(rootDir, "git-hooks")
    val gitHooksDir = File(rootDir, ".git/hooks")

    onlyIf {
        if (!gitHooksDir.exists()) {
            println("No .git/hooks directory found. Skipping hooks installation.")
            false
        } else {
            true
        }
    }

    from(scriptsFile) { include("**/*") }

    filesMatching("**/*") {
        filePermissions {
            // 0b111_101_101
            unix(493)
        }
    }
    into(gitHooksDir)

    doLast { println("Task : Inited git-hooks executed done.") }
}

tasks.jar { dependsOn(tasks.spotlessApply) }

tasks.prepareKotlinBuildScriptModel { dependsOn("initGitHooks") }
