package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication3.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_fifteen_percent -> 0.15
            else -> 0.10
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundTip.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val locale = Locale("si", "LK")
        val formattedTip = NumberFormat.getCurrencyInstance(locale).format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)


    }

}