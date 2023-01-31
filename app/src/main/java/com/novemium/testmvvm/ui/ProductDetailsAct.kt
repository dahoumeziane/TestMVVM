package com.novemium.testmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.novemium.testmvvm.R
import com.novemium.testmvvm.data.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val product = intent!!.extras!!.getSerializable("product") as Product
        back_btn.setOnClickListener {
            onBackPressed()
        }
        product_title.text = product.product_name
        product_price.text = "$ ${product.price}"
        Picasso.get().load(product.images_url.small).into(product_image)
        product_description.text = product.description
        product_brand.text = "by ${product.c_brand.name}"

    }
}