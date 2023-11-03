package com.example.monitoring.api

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderUseCase: OrderUseCase,
) {

    /* 그라파나 메트릭 등록 예제의 단순함을 위해 Get 사용 */
    @GetMapping("/order")
    fun order(): String {
        log.info("controller order")
        orderUseCase.order()
        return "order"
    }

    @GetMapping("/cancel")
    fun cancel(): String {
        log.info("controller cancel")
        orderUseCase.cancel()
        return "cancel"
    }

    @GetMapping("/stock")
    fun getStock(): String {
        log.info("controller stock")
        return "${orderUseCase.getStock()}"
    }

    companion object : Logger()
}