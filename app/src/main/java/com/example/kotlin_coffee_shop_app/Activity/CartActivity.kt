package com.example.kotlin_coffee_shop_app.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_coffee_shop_app.Adapter.CartAdapter
import com.example.kotlin_coffee_shop_app.Helper.ChangeNumberItemsListener
import com.example.kotlin_coffee_shop_app.Helper.ManagmentCart
import com.example.kotlin_coffee_shop_app.R
import com.example.kotlin_coffee_shop_app.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    lateinit var binding:ActivityCartBinding
    lateinit var managementCart:ManagmentCart
    private var tax:Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managementCart= ManagmentCart(this)

        calculateCart()
        setVariable()
        initCartList()
    }

    private fun initCartList() {
        binding.apply {
            listView.layoutManager=LinearLayoutManager(this@CartActivity,LinearLayoutManager.VERTICAL,false)
            listView.adapter=CartAdapter(
                managementCart.getListCart(),
                this@CartActivity,
                object :ChangeNumberItemsListener{
                    override fun onChanged() {
                        calculateCart()
                    }

                }
            )
        }
    }

    private fun setVariable() {
        binding.backBtn.setOnClickListener{finish()}
    }

    private fun calculateCart() {
     val percentTax=0.02
      val delivery=15
      tax=((managementCart.getTotalFee()*percentTax)*100)/100.0
        val total =((managementCart.getTotalFee()+tax+delivery)*100)/100
        val itemTotal=(managementCart.getTotalFee()*100)/100
        binding.apply {
            totalTaxTxt.text="$$itemTotal"
            totalTaxTxt.text ="$$tax"
            deliveryTxt.text="$$delivery"
            totalTaxTxt.text="$$total"
        }
    }


}