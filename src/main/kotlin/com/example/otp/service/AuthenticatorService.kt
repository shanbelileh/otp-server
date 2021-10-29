package com.example.otp.service

import com.warrenstrange.googleauth.GoogleAuthenticator
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig
import com.warrenstrange.googleauth.HmacHashFunction
import com.warrenstrange.googleauth.KeyRepresentation
import java.util.concurrent.TimeUnit

/**
 * @author : mohammad
 * @since : 10/22/2021 12:04 PM , Fri
 * otp-server
 **/
object AuthenticatorService {

    private const val WINDOW_LEN = 30


    fun generate(secret: String, digits: Int): Int {
        val config = GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder()
            .setCodeDigits(digits)
            .setHmacHashFunction(HmacHashFunction.HmacSHA512)
            .setKeyRepresentation(KeyRepresentation.BASE64)
            .build()

        val auth = GoogleAuthenticator(config)

        return auth.getTotpPassword(secret)
    }


    fun check(secret: String, digits: Int, code: Int, validity: Int): Boolean {
        val config = GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder()
            .setCodeDigits(digits)
            .setHmacHashFunction(HmacHashFunction.HmacSHA512)
            .setKeyRepresentation(KeyRepresentation.BASE64)
            .setWindowSize(validity / WINDOW_LEN)
            .build()

        val auth = GoogleAuthenticator(config)

        return auth.authorize(secret, code)
    }
}