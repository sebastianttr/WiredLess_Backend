package com.wiredless.backendService.wiredless

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@ComponentScans
class WiredlessApplication{}

fun main(args: Array<String>) {
	runApplication<WiredlessApplication>(*args)
}

