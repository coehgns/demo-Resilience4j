package com.example.demoresilience4j.service

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class CircuitBreakerTestService {

    /**
     * RunTimeException이 뜨도록 요청을 9번 보내고 정상적인 요청을 1번 보냈지만 실패율이 임계치를 넘어가서 fallBackCatImg 메서드가 발생됨.
     */
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