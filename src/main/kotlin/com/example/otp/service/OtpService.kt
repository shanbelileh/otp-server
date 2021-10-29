package com.example.otp.service

import com.example.otp.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import java.sql.Timestamp
import java.time.Instant

/**
 * @author : mohammad
 * @since : 10/22/2021 12:13 PM , Fri
 * otp-server
 **/
@Service
class OtpService {
    @Autowired
    lateinit var crypto: CryptoService

    @Autowired
    lateinit var userRepository: UserRepository;

    @Transactional
    fun generate(username: String): Int {

        val entity = userRepository.findByUsername(username)
        entity?.let {
            if (entity.key.isEmpty()) {
                entity.key = crypto.baseKey(entity.username)
                userRepository.save(entity)
            }

            val key = entity.secret()
            val code = key encode key.len
            println("code for $username is $code")
            return code

        } ?: throw IllegalArgumentException("user not found!!!")
    }


    @Transactional(readOnly = true)
    fun validate(username: String, code: Int): Boolean {

        val key = (userRepository.findByUsername(username))?.secret()

        return key?.let { code in key validity 150 } ?: false

//        return key?.let { code in key } ?: false
    }


}