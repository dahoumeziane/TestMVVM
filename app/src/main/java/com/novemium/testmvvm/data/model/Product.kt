package com.novemium.testmvvm.data.model

data class Product(
    val product_id: String,
    val product_name: String,
    val description: String,
    val price: Float,
    val images_url: Image,
    val c_brand: Brand,
    val is_productSet: Boolean,
    val is_special_brand: Boolean
)

data class Image(
    val small: String?,
    val large: String?,
)

data class Brand(
    val id: String,
    val name: String
)