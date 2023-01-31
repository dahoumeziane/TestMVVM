package com.novemium.testmvvm.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.novemium.testmvvm.R
import com.novemium.testmvvm.data.model.Product
import com.novemium.testmvvm.ui.ProductDetailsAct
import com.novemium.testmvvm.ui.viewHolder.ProductViewHolder
import com.squareup.picasso.Picasso

class ProductAdapter(
    val data: ArrayList<Product>,
    val context: Context
) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Picasso.get().load(data[position].images_url.small).into(holder.product_image)
        holder.product_price.text = "$ ${data[position].price}"
        holder.product_description.text = data[position].description
        holder.product_name.text = data[position].product_name
        holder.product_brand.text = "by ${data[position].c_brand.name}"
        holder.buy_product.setOnClickListener {
            context.startActivity(Intent( context,ProductDetailsAct::class.java).putExtra("product",data[position]))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}