package com.novemium.testmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.novemium.testmvvm.R
import com.novemium.testmvvm.ui.adapter.ProductAdapter
import com.novemium.testmvvm.viewModel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  lateinit var productVm : ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        products_list.layoutManager = LinearLayoutManager(this)
        // product api
        productVm = ViewModelProvider(this)[ProductViewModel::class.java]
        productVm.getProducts()
        productVm.productRes.observe(this){
            if(it!=null){
                if(it.isNotEmpty()){

                    products_list.adapter = ProductAdapter(it,this)
                    fetching_lin.visibility  = View.GONE

                }else{
                    fetching_lin.visibility  = View.VISIBLE
                }
            }
        }
    }
}