package com.example.kotlin_coffee_shop_app.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_coffee_shop_app.databinding.ActivityMainBinding
import com.bumptech.glide.Glide;
import com.example.kotlin_coffee_shop_app.Adapter.CategoryAdapter
import com.example.kotlin_coffee_shop_app.Adapter.PopularAdapter
import com.example.kotlin_coffee_shop_app.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
   private val viewModel= MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
        initCategory()
        initPopular()
    }

    private fun initPopular() {
      binding.popularProgressBar.visibility=View.VISIBLE
        viewModel.loadPopular().observeForever{
            binding.recyclerViewPopular.layoutManager=GridLayoutManager(this,2)
            binding.recyclerViewPopular.adapter=PopularAdapter(it)
            binding.popularProgressBar.visibility=View.GONE
        }
        viewModel.loadPopular()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun initCategory() {
      binding.categoryProgressBar.visibility=View.VISIBLE
        viewModel.loadCategory().observeForever{
            binding.categoryView.layoutManager=LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.HORIZONTAL,false
            )
            binding.categoryView.adapter=CategoryAdapter(it)
            binding.categoryProgressBar.visibility=View.GONE
        }
        viewModel.loadCategory()
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