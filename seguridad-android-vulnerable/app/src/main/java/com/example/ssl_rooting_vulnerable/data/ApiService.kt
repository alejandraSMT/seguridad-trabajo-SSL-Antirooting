package com.example.ssl_rooting_vulnerable.data

import com.example.ssl_rooting_vulnerable.domain.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/login")
    suspend fun login(@Body request: LoginRequest): retrofit2.Response<Map<String, Any>>
}