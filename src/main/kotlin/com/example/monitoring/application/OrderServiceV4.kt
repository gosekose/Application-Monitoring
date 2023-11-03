package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import java.util.Random
import java.util.concurrent.atomic.AtomicInteger

class OrderServiceV4(
    private val registry: MeterRegistry,
) : OrderUseCase {

    private var stock = AtomicInteger(1000)

    override fun order() {
        Timer.builder("my.order")
            .tag("class", this.javaClass.name)
            .tag("method", "order")
            .description("order")
            .register(registry)
            .record(Runnable {
                log.info("order")
                stock.decrementAndGet()

                sleep(500)
            })
    }

    override fun cancel() {
        Timer.builder("my.order")
            .tag("class", this.javaClass.name)
            .tag("method", "cancel")
            .description("order")
            .register(registry)
            .record(Runnable {
                log.info("cancel")
                stock.incrementAndGet()

                sleep(600)
            })
    }

    private fun sleep(time: Long) {
        try {
            Thread.sleep(time + Random().nextLong(200))
        } catch (e: InterruptedException) {
            throw e
        }
    }

    override fun getStock(): AtomicInteger {
        return stock
    }

    companion object : Logger()
}