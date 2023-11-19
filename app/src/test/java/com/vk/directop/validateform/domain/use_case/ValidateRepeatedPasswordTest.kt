package com.vk.directop.validateform.domain.use_case

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidateRepeatedPasswordTest {

    private lateinit var validateRepeatedPassword: ValidateRepeatedPassword

    @Before
    fun setUp() {
        validateRepeatedPassword = ValidateRepeatedPassword()
    }

    @Test
    fun `If password equals repeatedPassword return true`(){
       val result = validateRepeatedPassword.execute("123qwert", "123qwert")
        assertEquals(true, result.successful)
    }

    @Test
    fun `If password not equals repeatedPassword return false`(){
        val result = validateRepeatedPassword.execute("123qwery", "123qwert")
        assertEquals(false, result.successful)
    }
}