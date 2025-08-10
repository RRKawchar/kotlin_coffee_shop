package com.example.kotlin_coffee_shop_app.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_coffee_shop_app.Repository.MainRepository
import com.example.kotlin_coffee_shop_app.domain.BannerModel
import com.example.kotlin_coffee_shop_app.domain.CategoryModel
import com.example.kotlin_coffee_shop_app.domain.ItemsModel

class MainViewModel : ViewModel() {
    private val repository=MainRepository()
    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular():LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }
}