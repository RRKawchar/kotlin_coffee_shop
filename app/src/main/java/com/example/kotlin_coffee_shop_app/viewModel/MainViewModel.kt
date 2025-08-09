package com.example.kotlin_coffee_shop_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_coffee_shop_app.Repository.MainRepository
import com.example.kotlin_coffee_shop_app.domain.BannerModel

class MainViewModel : ViewModel() {
    private val repository=MainRepository()
    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }
}