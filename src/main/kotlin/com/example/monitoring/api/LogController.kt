package com.example.monitoring.api

import com.example.monitoring.util.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogController {

    @GetMapping("/log")
    fun log(): String {
        log.trace("log trace")
        log.debug("log debug")
        log.info("log info")
        log.warn("log warn")
        log.error("log error")

        return "ok"
    }

    companion object : Logger()

}