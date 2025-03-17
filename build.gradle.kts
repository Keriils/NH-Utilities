plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("online.keriils.plugins.spotless-wrapper") version "0.1.1"
}

wrapperSpotless { spotlessConfigGroovyGradle = false }

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
