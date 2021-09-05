package com.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.colormyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners() {
        val clickableViews : List<View> =
            listOf(
                binding.boxOneTextview,
                binding.boxTwoTextview,
                binding.boxThreeTextview,
                binding.boxFourTextview,
                binding.boxFiveTextview,
                binding.constraintLayout,
                binding.redButton,
                binding.yellowButton,
                binding.greenButton)
        for (item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {

        when(view.id){
            // Boxes using Color class colors for background
            R.id.box_one_textview -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_textview -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_textview -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_textview -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_textview -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> binding.boxThreeTextview.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFourTextview.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveTextview.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}