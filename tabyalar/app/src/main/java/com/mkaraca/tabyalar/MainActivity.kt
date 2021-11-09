package com.mkaraca.tabyalar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<FrameLayout>(R.id.frame00).setOnClickListener{
            findViewById<FrameLayout>(R.id.frame00).visibility=View.INVISIBLE
            findViewById<FrameLayout>(R.id.frame11).visibility=View.VISIBLE
            findViewById<FrameLayout>(R.id.frame12).visibility=View.VISIBLE
        }
        findViewById<FrameLayout>(R.id.frame11).setOnClickListener {
            findViewById<FrameLayout>(R.id.frame11).visibility=View.INVISIBLE
            findViewById<FrameLayout>(R.id.frame12).visibility=View.INVISIBLE

        }
    }
}