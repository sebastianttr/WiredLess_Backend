package com.wiredless.backendService.wiredless.Services.Impl

import com.wiredless.backendService.wiredless.Services.IProjectHandler
import org.apache.tomcat.jni.Proc
import org.apache.tomcat.util.http.fileupload.FileUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.File
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.writeBytes

@Component
class ProjectHandler : IProjectHandler {
    val logger = LoggerFactory.getLogger(javaClass)

    override fun createProject(name: String, author: String, type: IProjectHandler.ProjectType) {
        val currentWorkingPath:String = Paths.get("").toAbsolutePath().toString() + "/projects/" + name + "_" + author
        val file: File = File(currentWorkingPath)
        file.mkdirs()

        when(type){
            IProjectHandler.ProjectType.JavaScript_Express ->{
                val projectFile: File = File("$currentWorkingPath/$name")
                file.mkdirs()

                val npmCreateCommands = arrayOf(
                    ProcessBuilder().command("npm.cmd","config","set","init.author.name","\"$author\""),
                    ProcessBuilder().command("npm.cmd","config","set","init.version","\"1.0.0\""),
                    ProcessBuilder().command("npm.cmd","config","set","init.license","\"MIT\""),
                    ProcessBuilder().command("npm.cmd","init","-y")
                )

                val starterScript:String = "console.log(\"Hello World\");"

                try{
                    if(!File(Paths.get("${projectFile.absolutePath}/src").toAbsolutePath().toString()).exists()){
                        Files.createDirectories(Paths.get("${projectFile.absolutePath}/src").toAbsolutePath());
                        Files.createFile(Paths.get("${projectFile.absolutePath}/src/index.js").toAbsolutePath())
                            .writeBytes(starterScript.toByteArray(StandardCharsets.UTF_8))
                    }

                    for(cmd:ProcessBuilder in npmCreateCommands){
                        cmd.directory(File("$currentWorkingPath/$name"))
                        val process:Process = cmd.start()
                        process.waitFor()
                    }
                }
                catch (e:Exception){
                    logger.error("Error creating paths.",e)
                }

            }
            else -> {}
        }

    }
}