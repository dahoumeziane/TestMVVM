package com.novemium.testmvvm.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.novemium.testmvvm.data.model.Product
import com.novemium.testmvvm.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepo {
    val productsRes : MutableLiveData<ArrayList<Product>> = MutableLiveData()

    fun getProducts(

        onResult: (MutableLiveData<ArrayList<Product>>?) -> Unit
    ){
        val call = RetrofitInstance.productsApi.getProducts()
        call.enqueue(object : Callback<ArrayList<Product>> {
            override fun onResponse(call: Call<ArrayList<Product>>, response: Response<ArrayList<Product>>) {
                // we can test here different type of responses
                productsRes.value = response.body()
                onResult(productsRes)
            }

            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                Log.e("error", t.message.toString())
                onResult(productsRes)

            }
        })
    }

}