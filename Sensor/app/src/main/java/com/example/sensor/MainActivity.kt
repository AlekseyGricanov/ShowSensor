package com.example.sensor

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = ConstraintLayout(findViewById(R.id.linearLayout))
        val textView = findViewById(R.id.name_sensor) as ViewText
        // устанавливаем текста
        textView.setText = "SPCE"


        val layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        textView.layoutParams = layoutParams

        constraintLayout.addView(textView)
        setContentView(constraintLayout)
    }

    fun onClick(view: View?) {
        val linearLayout = findViewById<View>(R.id.linearLayout) as LinearLayout

    }
}