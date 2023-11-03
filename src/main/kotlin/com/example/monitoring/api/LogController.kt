package com.example.monitoring.api

import com.example.monitoring.util.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class LogController {

    @GetMapping("/log")
    fun log(): String {
        log.info("[REQUEST LOG] THIS TIME = ${LocalDateTime.now()}, Request URI = /log")
        return "ok"
    }

    companion object : Logger()

}