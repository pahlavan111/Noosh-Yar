pluginManagement {
    repositories {
//        maven { url = uri("https://maven.aliyun.com/repository/google") }
//        maven { url = uri("https://maven.aliyun.com/repository/central") }
//        maven { url = uri("https://maven.aliyun.com/repository/public") }
//        maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental") }
//        google()
        maven { url = uri("https://maven.myket.ir") }

        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
//        maven { url = uri("https://maven.aliyun.com/repository/google") }
//        maven { url = uri("https://maven.aliyun.com/repository/central") }
//        maven { url = uri("https://maven.aliyun.com/repository/public") }
//        google()
        maven { url = uri("https://maven.myket.ir") }

    }
}

rootProject.name = "Beer Store"
include(":app")
include(":domain")
include(":data")
include(":checkconnectivity")