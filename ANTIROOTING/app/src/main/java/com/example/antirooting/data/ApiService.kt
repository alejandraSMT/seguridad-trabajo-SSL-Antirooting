package com.example.antirooting.data

import com.example.antirooting.domain.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/login")
    suspend fun login(@Body request: LoginRequest): retrofit2.Response<Map<String, Any>>
}