package com.example.hits.model

data class Media(
    val admin_graphql_api_id: String,
    val alt: Any,
    val created_at: String,
    val height: Int,
    val id: Long,
    val position: Int,
    val product_id: Long,
    val src: String,
    val updated_at: String,
    val variant_ids: List<Any>,
    val width: Int
)