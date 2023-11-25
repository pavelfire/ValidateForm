package com.vk.directop.validateform.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.directop.validateform.domain.use_case.ValidateEmail
import com.vk.directop.validateform.domain.use_case.ValidatePassword
import com.vk.directop.validateform.domain.use_case.ValidateRepeatedPassword
import com.vk.directop.validateform.domain.use_case.ValidateTerms
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword(),
    private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
    private val validateTerms: ValidateTerms = ValidateTerms()
) : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }

            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }

            is RegistrationFormEvent.Submit -> {
                submitDate()
            }

            RegistrationFormEvent.CategorizedList -> {
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.GoToCategorizedList)
                }
            }

            RegistrationFormEvent.GoToSupportScreen -> {
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.GoToSupportScreen)
                }
            }

            RegistrationFormEvent.GoToFibonacciScreen -> {
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.GoToFibonacciScreen)
                }
            }

            RegistrationFormEvent.GoToShowImageScreen -> {
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.GoToShowImageScreen)
                }
            }

            RegistrationFormEvent.GoToMainScreen ->{
                viewModelScope.launch {
                    validationEventChannel.send(ValidationEvent.GoToMainScreen)
                }
            }

        }
    }

    private fun submitDate() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult =
            validateRepeatedPassword.execute(state.password, state.repeatedPassword)
        val termsResult = validateTerms.execute(state.acceptedTerms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage,
                termsError = termsResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
        object GoToCategorizedList : ValidationEvent()
        object GoToSupportScreen : ValidationEvent()
        object GoToFibonacciScreen: ValidationEvent()
        object GoToShowImageScreen: ValidationEvent()
        object GoToMainScreen: ValidationEvent()
    }
}