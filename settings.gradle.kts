pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}

rootProject.name = "LinkDeck"
include(":app")
include(":core-design")
include(":core-network")
include(":core-adb")
include(":feature-pairing")
include(":feature-mirror")
include(":feature-files")
include(":feature-notifications")
include(":feature-calls")
