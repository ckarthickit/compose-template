// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val buildScriptPluginsIterator = BuildScriptPlugins.values().iterator()
        //classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        while (buildScriptPluginsIterator.hasNext()) {
            classpath(buildScriptPluginsIterator.next().artifact)
        }
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}