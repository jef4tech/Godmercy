package com.jef4tech.godmercy.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jef4tech.godmercy.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigateMain()
    }
    private fun NavigateMain() {
        val nextScreenIntent = Intent(this, Home::class.java)
        startActivity(nextScreenIntent)
    }
}