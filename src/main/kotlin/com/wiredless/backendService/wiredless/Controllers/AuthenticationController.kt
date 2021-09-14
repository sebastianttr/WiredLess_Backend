package com.wiredless.backendService.wiredless.Controllers

import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController {

    @GetMapping("/registerNewUser")
    fun registerNewUser(): ResponseEntity<String> {
        return ResponseEntity("Register OK",HttpStatus.OK)
    }
}