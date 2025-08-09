package com.example.kotlin_coffee_shop_app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_coffee_shop_app.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge content drawing
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set button click to go to MainActivity
        binding.startBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finish splash so it doesn't stay in back stack
        }

        // Handle window insets (optional, good for immersive mode)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
