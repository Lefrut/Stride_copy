package com.application.common.phone

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil

fun isPhoneNumberValid(phone: String, region: String = "ru"): Boolean {
    val phoneUtil = PhoneNumberUtil.getInstance()
    return try {
        val number = phoneUtil.parse(phone, region)
        phoneUtil.isValidNumber(number)
    } catch (e: NumberParseException) {
        false
    }
}