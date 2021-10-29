package com.example.otp.service

import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

/**
 * @author : mohammad
 * @since : 10/22/2021 12:11 PM , Fri
 * otp-server
 **/
@Service
class CryptoService {

    fun baseKey(username: String): String {
        val salt = ByteArray(64)
        Random().nextBytes(salt)
        val kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val specs = PBEKeySpec(username.toCharArray(), salt, 1024, 256)
        val key = kf.generateSecret(specs)
        val encoded = key.encoded
        return Base64.getEncoder().encodeToString(encoded)
    }

    fun derivedKey(bdk: String): String {
        val salt = ByteArray(64)
        Random().nextBytes(salt)
        val kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val specs = PBEKeySpec(bdk.toCharArray(), salt, 1024, 256)
        val key = kf.generateSecret(specs)
        val encoded = key.encoded
        return Base64.getEncoder().encodeToString(encoded)
    }

}