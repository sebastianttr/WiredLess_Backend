package com.wiredless.backendService.wiredless.Controllers

import com.wiredless.backendService.wiredless.Services.IProjectHandler
import com.wiredless.backendService.wiredless.Services.IScriptExecutor
import com.wiredless.backendService.wiredless.Services.Impl.ProjectHandler
import org.apache.catalina.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
class ScriptController  {

    val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var projectHandler: IProjectHandler

    @Autowired
    private lateinit var scriptHandler: IScriptExecutor

    @GetMapping("/executeCode")
    fun exectueNodeCode():ResponseEntity<String>{
        this.scriptHandler.executeScript("node_test","Wiredless",IProjectHandler.ProjectType.JavaScript_Express)
        return ResponseEntity("Executing String",HttpStatus.OK)
    }

    @GetMapping("/createNewProject")
    fun createNewProject():ResponseEntity<String>{
        this.projectHandler.createProject("node_test","Wiredless",IProjectHandler.ProjectType.JavaScript_Express);
        return ResponseEntity("Create new project under /projects folder",HttpStatus.OK)
    }

}