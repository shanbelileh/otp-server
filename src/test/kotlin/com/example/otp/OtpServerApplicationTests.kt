package com.example.otp

import com.example.otp.service.AuthenticatorService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

//@SpringBootTest
class OtpServerApplicationTests {

    @Test
    fun contextLoads() {

        val secret = "abcdefg"
        val generate = AuthenticatorService.generate(secret, 6)
        println(generate)
        val validity = 300
        (1..(validity)).forEach({
            Thread.sleep(1_000)
            val check = AuthenticatorService.check(secret, 6, generate, validity = validity)
            println("${it} : ${check}")
        })

    }

}
