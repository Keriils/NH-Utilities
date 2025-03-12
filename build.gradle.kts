plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("com.diffplug.spotless") version "7.0.2"
}

spotless {
    encoding("UTF-8")

    format("misc") {
        target(".gitignore")

        trimTrailingWhitespace()
        leadingSpacesToTabs()
        endWithNewline()
    }

    java {
        target("src/*/java/**/*.java", "src/*/scala/**/*.java")

        toggleOffOn()
        importOrder("java", "javax", "net", "org", "com")
        removeUnusedImports()
        eclipse("4.19").configFile(file("SpotlessPlugin/spotless.eclipseFormat.xml"))
        formatAnnotations()
    }

    kotlin {
        target("src/*/kotlin/**/*.kt")

        toggleOffOn()
        ktfmt("0.54").googleStyle().configure {
            it.setMaxWidth(120)
            it.setBlockIndent(4)
            it.setContinuationIndent(4)
            it.setRemoveUnusedImports(true)
            it.setManageTrailingCommas(true)
        }

        trimTrailingWhitespace()
        leadingSpacesToTabs()
        endWithNewline()
    }

    kotlinGradle {
        target("*.gradle.kts")

        toggleOffOn()
        ktfmt("0.54").googleStyle().configure {
            it.setMaxWidth(120)
            it.setBlockIndent(4)
            it.setContinuationIndent(4)
            it.setRemoveUnusedImports(true)
            it.setManageTrailingCommas(true)
        }

        trimTrailingWhitespace()
        endWithNewline()
    }
}
