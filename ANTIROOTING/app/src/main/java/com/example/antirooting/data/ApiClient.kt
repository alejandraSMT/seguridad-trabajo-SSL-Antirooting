package com.example.antirooting.data

import com.google.gson.GsonBuilder
import okhttp3.CertificatePinner
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
        private const val HOSTNAME = "10.0.2.2"
        private val certificatePinner = CertificatePinner.Builder()
            .add(HOSTNAME, "sha256/Pz9sZj99Pz9IED9CUmBERD8/IwM/Ij9FP3FiPz8gKj8NCg==")
            .build()
        fun getApiClient(): ApiClient {
            if (instance == null) {
                val service = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(
                        OkHttpClient
                            .Builder()
                            .certificatePinner(certificatePinner)
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