package com.example.monitoring

import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MonitoringApplication {

    @Bean
    fun httpExchangeRepository(): InMemoryHttpExchangeRepository {
        return InMemoryHttpExchangeRepository()
    }

}

fun main(args: Array<String>) {
    runApplication<MonitoringApplication>(*args)
}

