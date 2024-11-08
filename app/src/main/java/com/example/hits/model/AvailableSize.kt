package com.example.hits.model

data class AvailableSize(
    val id: Long,
    val inStock: Boolean,
    val inventoryQuantity: Int,
    val price: Int,
    val size: String,
    val sku: String
)