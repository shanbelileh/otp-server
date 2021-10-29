package com.example.otp.repository

import com.example.otp.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author : mohammad
 * @since : 10/22/2021 12:00 PM , Fri
 * otp-server
 **/
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}