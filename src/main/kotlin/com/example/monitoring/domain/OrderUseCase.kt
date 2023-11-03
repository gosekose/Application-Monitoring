package com.example.monitoring.domain

import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

@Component
interface OrderUseCase {
    fun order()

    fun cancel()

    fun getStock(): AtomicInteger
}