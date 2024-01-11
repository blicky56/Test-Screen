package com.tamdev.testscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tamdev.testscreen.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private var currentColorIndex = 0
    private val colors = intArrayOf(Color.GREEN, Color.RED, Color.BLUE, Color.WHITE, Color.BLACK, Color.YELLOW)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val constraintLayout: View = binding.ConstraintLayout


        constraintLayout.setOnClickListener {

            constraintLayout.setBackgroundColor(colors[currentColorIndex])


            currentColorIndex = (currentColorIndex + 1) % colors.size
        }
    }
}