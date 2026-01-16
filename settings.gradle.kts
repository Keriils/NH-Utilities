pluginManagement {
    repositories {
        maven {
            // RetroFuturaGradle
            name = "GTNH Maven"
            url = uri("https://nexus.gtnewhorizons.com/repository/public/")
            mavenContent {
                includeGroup("com.gtnewhorizons")
                includeGroupByRegex("com\\.gtnewhorizons\\..+")
            }
        }
        exclusiveContent {
            forRepository {
                maven {
                    name = "Jitpack"
                    url = uri("https://jitpack.io")
                }
            }
            filter { includeGroup("com.github.ElytraServers.elytra-conventions") }
        }
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

plugins { id("com.gtnewhorizons.gtnhsettingsconvention") version ("2.0.13") }
