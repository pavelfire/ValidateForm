package com.vk.directop.validateform.domain.use_case

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {

    private lateinit var validatePassword: ValidatePassword

    @Before
    fun setUp() {
        validatePassword = ValidatePassword()
    }

    @Test
    fun `Password is letter-only, returns error`(){
        val result = validatePassword.execute("abcdefgh")

        assertEquals(!result.successful, true)
    }

    @Test
    fun `Password is digits-only, returns error`(){
        val result = validatePassword.execute("12345678")

        assertEquals(!result.successful, true)
    }

    @Test
    fun `Password is least than 8 symbols, returns error`(){
        val result = validatePassword.execute("12345a")

        assertEquals(!result.successful, true)
    }

    @Test
    fun `Password is contains letters and digits, returns success`(){
        val result = validatePassword.execute("1abcdefgh")

        assertEquals(result.successful, true)
    }

}