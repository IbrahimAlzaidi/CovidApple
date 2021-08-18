package com.example.covidapple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the style back to normal after activating splash screen
        setTheme(R.style.Theme_CovidApple)

        setContentView(R.layout.activity_home)

        
    }
}