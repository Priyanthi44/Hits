package com.example.hits.network

import com.example.hits.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    val instance: Retrofit by lazy {
        val moshi: Moshi = Moshi.Builder().build()
        Retrofit.Builder().baseUrl(BASE_URL).client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }
}