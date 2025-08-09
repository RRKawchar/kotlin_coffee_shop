package com.example.kotlin_coffee_shop_app.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_coffee_shop_app.R
import com.example.kotlin_coffee_shop_app.databinding.ActivityMainBinding
import com.example.kotlin_coffee_shop_app.viewModel.MainViewModel
import com.bumptech.glide.Glide;

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel=MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
    }

    private fun initBanner() {
       binding.bannerProgressBar.visibility= View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.bannerProgressBar.visibility= View.GONE
        }
        viewModel.loadBanner()
    }
}