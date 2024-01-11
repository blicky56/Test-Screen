package com.tamdev.testscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tamdev.testscreen.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    fun onClickNext (view: View){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onClickNextcolors (view: View){

        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
}