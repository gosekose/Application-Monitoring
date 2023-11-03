package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import java.util.concurrent.atomic.AtomicInteger

class OrderServiceV2(
    private val registry: MeterRegistry,
) : OrderUseCase {

    private var stock = AtomicInteger(1000)

    override fun order() {
        log.info("order")
        stock.decrementAndGet()

        Counter.builder("my.order")
            .tag("class", this.javaClass.name)
            .tag("method", "order")
            .description("order")
            .register(registry)
            .increment()
    }

    override fun cancel() {
        log.info("cancel")
        stock.incrementAndGet()

        Counter.builder("my.order")
            .tag("class", this.javaClass.name)
            .tag("method", "cancel")
            .description("order")
            .register(registry)
            .increment()
    }

    override fun getStock(): AtomicInteger {
        return stock
    }

    companion object : Logger()
}