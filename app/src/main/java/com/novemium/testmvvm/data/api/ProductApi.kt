package com.novemium.testmvvm.data.api


import com.novemium.testmvvm.data.model.Product
import retrofit2.Call
import retrofit2.http.*

interface ProductApi {


    @GET("items.json")
    fun getProducts(

    ): Call<ArrayList<Product>>


}