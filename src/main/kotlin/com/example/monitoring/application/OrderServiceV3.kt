package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import io.micrometer.core.annotation.Counted
import java.util.concurrent.atomic.AtomicInteger

class OrderServiceV3 : OrderUseCase {

    private var stock = AtomicInteger(1000)

    /* micrometer AOP 적용 어노테이션, tag는 method 기준으로 분류해서 적용 */
    @Counted("my.order")
    override fun order() {
        log.info("order")
        stock.decrementAndGet()
    }

    @Counted("my.order")
    override fun cancel() {
        log.info("cancel")
        stock.incrementAndGet()
    }

    override fun getStock(): AtomicInteger {
        return stock
    }

    companion object : Logger()
}