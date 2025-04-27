plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("online.keriils.plugins.spotless-wrapper") version "0.1.3"
}

spotless { isEnforceCheck = false }

val alwaysApplySpotless = project.properties["alwaysApplySpotless"] == "true"
val isCiEnvironment = System.getenv("CI") == "true" || System.getenv("GITHUB_ACTIONS") == "true"

tasks.compileJava { if (alwaysApplySpotless) dependsOn(tasks.spotlessApply) }

tasks.compileJava { if (isCiEnvironment) dependsOn(tasks.spotlessCheck) }
