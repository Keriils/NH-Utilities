plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("online.keriils.plugins.spotless-wrapper") version "0.1.3"
}

spotless { isEnforceCheck = false }

val alwaysApplySpotless = project.properties["alwaysApplySpotless"] == "true"
val isCiEnvironment = System.getenv("CI") == "true" || System.getenv("GITHUB_ACTIONS") == "true"

tasks.compileJava { if (alwaysApplySpotless) dependsOn(tasks.spotlessApply) }

tasks.compileJava { if (isCiEnvironment) dependsOn(tasks.spotlessCheck) }

// 为 runClient 和 runServer 配置不同的目录
tasks.named<JavaExec>("runClient21") {
    workingDir = file("run/client")
    doFirst {
        // Ensure the client working directory exists
        workingDir.mkdirs()
    }
}

// Configure runServer to use 'run/server' directory
tasks.named<JavaExec>("runServer21") {
    workingDir = file("run/server")
    doFirst {
        // Ensure the server working directory exists
        workingDir.mkdirs()
    }
}
