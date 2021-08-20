package com.example.covidapple.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covidapple.databinding.ActivityHomeBinding
import com.example.covidapple.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader



class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFile()
    }

    private fun openFile(){
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentLine = parser.parse(it)
        }
    }

}