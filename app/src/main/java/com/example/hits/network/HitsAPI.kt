package com.example.hits.network

import com.example.hits.model.AllHits
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface HitsAPI {
    @GET("training/mock-product-responses/algolia-example-payload.json")
    suspend fun getProducts(): AllHits

}