package com.wiredless.backendService.wiredless.Services.Impl

import com.wiredless.backendService.wiredless.Services.Error.ScriptExecutionException
import com.wiredless.backendService.wiredless.Services.IProjectHandler
import com.wiredless.backendService.wiredless.Services.IScriptExecutor
import org.springframework.stereotype.Component
import java.io.File
import java.nio.file.Paths
import kotlin.jvm.Throws

@Component
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ScriptExecutor : IScriptExecutor{

    //@Throws(ScriptExecutionException::class)
    override fun executeScript(name: String, author: String, type: IProjectHandler.ProjectType, vararg executeArgs: String) {
        val workingPath = Paths.get("projects")

        val projectFiles = File(workingPath.toUri())

        for(projects:File in projectFiles.listFiles()){
            if(projects.isDirectory){
                if(projects.name.equals(name + "_" + author)){
                    val navigatingPathString = "${workingPath.toAbsolutePath()}/${name}_$author/${name}/src"

                    val procBuild = ProcessBuilder().command("node" , "index.js")
                    procBuild.directory(File(navigatingPathString))
                    procBuild.redirectOutput(ProcessBuilder.Redirect.INHERIT)

                    val process: Process = procBuild.start()

                    process.waitFor()

                    break
                }
            }
        }
    }
}