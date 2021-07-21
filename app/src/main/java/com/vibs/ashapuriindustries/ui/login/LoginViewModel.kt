package com.vibs.ashapuriindustries.ui.login

import android.app.Application
import androidx.lifecycle.*
import com.vibs.ashapuriindustries.R

import com.vibs.ashapuriindustries.data.ResponseManager
import com.vibs.ashapuriindustries.data.model.ResponseLogin
import com.vibs.ashapuriindustries.data.model.User
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val loginRepository: LoginRepository =
        LoginRepository(application)

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm
    private val _isLoading = MutableLiveData<Boolean>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        /*return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }*/
        return username.isNotBlank()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    fun isLoadingDisplay(flag: Boolean) {
        _isLoading.value = flag
    }

    fun userLogin(user: User): MutableLiveData<ResponseManager<ResponseLogin>> {
        val liveData = MutableLiveData<ResponseManager<ResponseLogin>>()
        viewModelScope.launch {
            liveData.value = loginRepository.userLogin(user).value
        }
        return liveData
    }
}