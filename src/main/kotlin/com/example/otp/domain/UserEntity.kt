package com.example.otp.domain

import com.example.otp.service.Secret
import javax.persistence.*

/**
 * @author : mohammad
 * @since : 10/22/2021 11:43 AM , Fri
 * otp-server
 **/
@Entity
@Table(name = "USERS")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var rowId: Long = 0

    lateinit var username: String;
    lateinit var key: String;

    fun secret(): Secret = Secret(key, len = 6)

    override fun toString(): String {
        return "UserEntity(rowId=$rowId, username='$username', key='$key')"
    }


}