package com.example.demoresilience4j.presentation

import com.example.demoresilience4j.service.CircuitBreakerTestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CircuitBreakerTestController(
    private val circuitBreakerTestService: CircuitBreakerTestService
) {
    @GetMapping("/cats/{id}/image")
    fun catImage(@PathVariable id: Long): String = circuitBreakerTestService.catImg(id = id)
}