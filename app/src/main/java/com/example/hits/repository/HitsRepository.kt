package com.example.hits.repository

import com.example.hits.data.DataOrException
import com.example.hits.model.AllHits
import com.example.hits.network.HitsAPI
import javax.inject.Inject

class HitsRepository (private val hitsService: HitsAPI) {
    suspend fun getHits(): DataOrException<AllHits, Boolean, Exception> {
        val response = try {
            hitsService.getProducts()
        } catch (e:Exception) {
            return DataOrException( e = e)
        }
        return DataOrException(data = response)
    }
}