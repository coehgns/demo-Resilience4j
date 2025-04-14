package com.example.demoresilience4j.service

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class CircuitBreakerTestService {

    @CircuitBreaker(
        name = "test-circuit-breaker",
        fallbackMethod = "fallBackCatImg"
    )
    fun catImg(id: Long): String {
        if (id < 10) {
            return "$id cat's img.png"
        }
        throw RuntimeException("error")
    }

    private fun fallBackCatImg(id: Long, t: Throwable): String {
        return "fallback cat image.png"
    }
}