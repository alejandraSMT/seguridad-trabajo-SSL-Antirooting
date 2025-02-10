package com.example.ssl_vulnerable.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASEURL = "https://10.0.2.2:3001"
class ApiClient(val service: ApiService) {
    companion object{
        private var instance : ApiClient? = null
        val gson = GsonBuilder()
            .setLenient()
            .create()
        fun getApiClient(): ApiClient {
            if (instance == null) {
                val service = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(
                        OkHttpClient
                            .Builder()
                            //.hostnameVerifier { _, _ -> true }
                            .build()
                    )
                    .build()
                    .create(ApiService::class.java)
                instance = ApiClient(service)
            }
            return instance!!
        }
    }
}