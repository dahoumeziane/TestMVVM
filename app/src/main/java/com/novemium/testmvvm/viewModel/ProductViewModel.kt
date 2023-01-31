package com.novemium.testmvvm.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.novemium.testmvvm.data.model.Product
import com.novemium.testmvvm.repository.ProductRepo

class ProductViewModel : ViewModel() {
    val productRes = MutableLiveData<ArrayList<Product>>()

    fun getProducts() {
        ProductRepo().getProducts {
            productRes.value = it!!.value
        }
    }
}