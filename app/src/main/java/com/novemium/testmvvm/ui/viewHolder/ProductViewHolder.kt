package com.novemium.testmvvm.ui.viewHolder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.novemium.testmvvm.R


class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var product_image: RoundedImageView
    lateinit var product_price: TextView
    lateinit var product_name : TextView
    lateinit var product_brand: TextView
    lateinit var product_description: TextView
    lateinit var buy_product: Button

    init {
        product_image = itemView.findViewById(R.id.product_image)
        product_name = itemView.findViewById(R.id.product_title)
        product_price = itemView.findViewById(R.id.product_price)
        product_brand = itemView.findViewById(R.id.product_brand)
        product_description = itemView.findViewById(R.id.product_description)
        buy_product = itemView.findViewById(R.id.buy_btn)
    }
}
