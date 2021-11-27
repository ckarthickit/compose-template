package com.ckarthickit.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.*

class InstallGitHooksPlugin : Plugin<Project>{
    override fun apply(target: Project) {
        target.afterEvaluate {
            exec {
                workingDir = project.rootDir
                commandLine("${rootProject.rootDir}/config/git-hooks/copyGitHooks.sh", "${rootProject.rootDir}")
            }
        }
    }
}


//Couldn't find a task to add dependency to on the root-project. So the below code is useless as of now.
private fun isLinuxOrMacOs(): Boolean {
    val osName = System.getProperty("os.name").toLowerCase(Locale.ROOT)
    return osName.contains("linux") || osName.contains("mac os") || osName.contains("macos")
}
