package com.example.monitoring.application

import com.example.monitoring.domain.OrderUseCase
import io.micrometer.core.aop.CountedAspect
import io.micrometer.core.aop.TimedAspect
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

    fun applyV3(): OrderUseCase {
        return OrderServiceV3()
    }

    fun applyCountedAspect(registry: MeterRegistry): CountedAspect {
        return CountedAspect(registry)
    }

    fun applyV4(registry: MeterRegistry): OrderUseCase {
        return OrderServiceV4(registry)
    }

    @Bean
    fun applyV5(): OrderUseCase {
        return OrderServiceV5()
    }

    @Bean
    fun applyTimedAspect(registry: MeterRegistry): TimedAspect {
        return TimedAspect(registry)
    }
}