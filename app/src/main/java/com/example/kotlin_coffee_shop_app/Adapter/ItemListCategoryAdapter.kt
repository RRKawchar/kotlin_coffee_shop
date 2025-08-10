package com.example.kotlin_coffee_shop_app.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin_coffee_shop_app.databinding.ViewholderItemListBinding
import com.example.kotlin_coffee_shop_app.databinding.ViewholderPopularBinding
import com.example.kotlin_coffee_shop_app.domain.ItemsModel

class ItemListCategoryAdapter(val items:MutableList<ItemsModel>):
    RecyclerView.Adapter<ItemListCategoryAdapter.Viewholder>() {

        lateinit var context: Context

    class Viewholder(val binding:ViewholderItemListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListCategoryAdapter.Viewholder {
        context=parent.context
        val binding=ViewholderItemListBinding.inflate(
            LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemListCategoryAdapter.Viewholder, position: Int) {
       holder.binding.titleTxt.text=items[position].title
        holder.binding.priceTxt.text="$"+items[position].price.toString()
        holder.binding.subtitleTxt.text=items[position].extra
        Glide.with(context).load(items[position].picUrl[0])
            .into(holder.binding.pic)
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int =items.size


}