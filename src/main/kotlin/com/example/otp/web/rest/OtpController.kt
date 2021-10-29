package com.example.otp.web.rest

import com.example.otp.service.OtpService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author : mohammad
 * @since : 10/22/2021 11:34 AM , Fri
 * otp-server
 **/
@RestController
@RequestMapping("api/otp")
class OtpController {


    @Autowired
    lateinit var service: OtpService

    @PostMapping("{user-name}/generate")
    fun generate(@PathVariable("user-name") username: String): ResponseEntity<Int> =
        ResponseEntity.ok(service.generate(username))

    @GetMapping("{user-name}/validate/{otp}")
    fun validate(@PathVariable("user-name") username: String, @PathVariable("otp") otp: Int)
            : ResponseEntity<Boolean> = ResponseEntity.ok(service.validate(username, otp))
}