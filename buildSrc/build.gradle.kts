plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("installGitHooks") {
            id = "install-git-hooks"
            implementationClass = "com.ckarthickit.gradle.InstallGitHooksPlugin"
        }
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

