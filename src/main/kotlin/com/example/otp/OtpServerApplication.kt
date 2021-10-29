package com.example.otp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OtpServerApplication

fun main(args: Array<String>) {
	runApplication<OtpServerApplication>(*args)
}
