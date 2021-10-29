package com.example.otp.service

/**
 * @author : mohammad
 * @since : 10/22/2021 12:01 PM , Fri
 * otp-server
 **/
class Secret(var key: String = "", var len: Int = 4, var validity: Int = 120) {

    operator fun times(digits: Int): Int = key.toOtp(digits)

    operator fun contains(code: Int): Boolean = AuthenticatorService.check(key, len, code, validity)

    public infix fun encode(digits: Int): Int = key.toOtp(digits)
    public infix fun check(code: Int): Boolean = AuthenticatorService.check(key, len, code, validity)

    public infix fun expand(len: Int): Secret {
        this.len = len;
        return this;
    }

    public infix fun validity(seconds: Int): Secret {
        this.validity = seconds;
        return this;
    }


}


fun String.toOtp(digits: Int): Int {
    return AuthenticatorService.generate(this, digits)
}