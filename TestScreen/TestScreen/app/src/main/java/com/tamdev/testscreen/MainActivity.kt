package com.tamdev.testscreen

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.tamdev.testscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var circleView: View
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rootLayout = findViewById<LinearLayout>(R.id.yourView)

        val circleDrawable = ShapeDrawable(OvalShape())
        circleDrawable.paint.color = Color.RED
        circleDrawable.setBounds(0, 0, 100, 100)

        circleView = View(this)
        circleView.background = circleDrawable
        circleView.visibility = View.INVISIBLE

        val layoutParams = LinearLayout.LayoutParams(100, 100)
        layoutParams.leftMargin = 0
        layoutParams.topMargin = 0
        rootLayout.addView(circleView, layoutParams)

        rootLayout.setOnTouchListener { _, event ->
            handleTouch(event)
            binding.vw2.visibility = View.GONE
            true
        }
    }

    private fun handleTouch(event: MotionEvent): Boolean {
        val x = event.rawX
        val y = event.rawY

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

                if (circleView.visibility != View.VISIBLE) {

                    val layoutParams = LinearLayout.LayoutParams(100, 100)
                    layoutParams.leftMargin = x.toInt() - 50
                    layoutParams.topMargin = y.toInt() - 50
                    circleView.layoutParams = layoutParams


                    circleView.visibility = View.VISIBLE
                }
            }
            MotionEvent.ACTION_MOVE -> {

                val layoutParams = circleView.layoutParams as LinearLayout.LayoutParams
                layoutParams.leftMargin = x.toInt() - 50
                layoutParams.topMargin = y.toInt() - 50
                circleView.layoutParams = layoutParams
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {

                circleView.visibility = View.INVISIBLE
            }
        }

        return true
    }
}

