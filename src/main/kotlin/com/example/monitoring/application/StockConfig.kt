package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import com.example.monitoring.util.Logger
import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.MeterBinder
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StockConfig {

    fun applyMyStockMetricV1(orderUseCase: OrderUseCase, registry: MeterRegistry): MyStockMetricV1 {
        return MyStockMetricV1(orderUseCase, registry)
    }

    @Bean
    fun applyMeterBinder(
        orderUseCase: OrderUseCase
    ): MeterBinder {
        return MeterBinder { registry: MeterRegistry ->
            Gauge.builder("my.stock", orderUseCase) {
                log.info("stock gauge call")
                it.getStock().toDouble()
            }.register(registry)
        }
    }

    class MyStockMetricV1(
        private val orderUseCase: OrderUseCase,
        private val registry: MeterRegistry,
    ) {

        @PostConstruct
        fun init() {
            Gauge.builder("my.stock", orderUseCase) {
                log.info("stock gauge call")
                it.getStock().toDouble()
            }.register(registry)
        }

        companion object : Logger()

    }

    companion object : Logger()

}