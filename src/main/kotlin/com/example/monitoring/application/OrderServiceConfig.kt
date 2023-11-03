package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import io.micrometer.core.aop.CountedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OrderServiceConfig {

    fun applyV1(): OrderUseCase {
        return OrderServiceV1()
    }

    fun applyV2(registry: MeterRegistry): OrderUseCase {
        return OrderServiceV2(registry)
    }

    @Bean
    fun applyV3(): OrderUseCase {
        return OrderServiceV3()
    }

    @Bean
    fun applyCountedAspect(registry: MeterRegistry): CountedAspect {
        return CountedAspect(registry)
    }
}