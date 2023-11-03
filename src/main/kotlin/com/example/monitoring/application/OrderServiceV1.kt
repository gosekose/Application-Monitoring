package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import java.util.concurrent.atomic.AtomicInteger

class OrderServiceV1 : OrderUseCase {

    private var stock = AtomicInteger(1000)

    override fun order() {
        log.info("order")
        stock.decrementAndGet()
    }

    override fun cancel() {
        log.info("cancel")
        stock.incrementAndGet()
    }

    override fun getStock(): AtomicInteger {
        return stock
    }

    companion object : Logger()
}