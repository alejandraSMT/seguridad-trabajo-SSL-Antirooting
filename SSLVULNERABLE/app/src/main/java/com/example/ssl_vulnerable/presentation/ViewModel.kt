package com.example.ssl_vulnerable.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ssl_vulnerable.data.ApiClient
import com.example.ssl_vulnerable.domain.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(

) : ViewModel() {

    private val _user = MutableStateFlow("")
    val user: StateFlow<String>
        get() = _user.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String>
        get() = _password.asStateFlow()

    fun userChange(it: String) {
        _user.value = it
    }

    fun passwordChange(it: String) {
        _password.value = it
    }

    fun login() {
        viewModelScope.launch {
            try {
                val response = ApiClient
                    .getApiClient()
                    .service
                    .login(LoginRequest(user.value, password.value))
                Log.i("Response login: ", response.body().toString())
            }catch (e: Exception) {
                Log.e("Error login: ", e.message.toString())
            }
        }
    }

}