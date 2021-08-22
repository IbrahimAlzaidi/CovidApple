package com.example.covidapple.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.covidapple.R
import com.example.covidapple.data.DataManger
import com.example.covidapple.databinding.ActivityHomeBinding
import com.example.covidapple.ui.fragments.DetailsFragment
import com.example.covidapple.ui.fragments.HomeFragment
import com.example.covidapple.ui.fragments.InfoFragment
import com.example.covidapple.ui.fragments.SearchFragment
import com.example.covidapple.util.CsvParser
import com.example.covidapple.util.log
import java.io.BufferedReader
import java.io.InputStreamReader



class HomeActivity : AppCompatActivity() {

    private val fragmentHome = HomeFragment()
    private val fragemntSearch = SearchFragment()
    private val fragmentInfo = InfoFragment()
    private val fragmentDetails = DetailsFragment()

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the style back to normal after activating splash screen
        setTheme(R.style.Theme_CovidApple)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFile()
        addNavigationListener()
    }

    private fun addNavigationListener() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            replaceFragment(
                when(item.itemId){
                    R.id.nav_home -> fragmentHome
                    R.id.nav_info -> fragmentInfo
                    R.id.nav_search -> fragemntSearch
                    R.id.nav_details -> fragmentDetails
                    else -> return@setOnItemSelectedListener  false
                }
            )
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(newFragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, newFragment)
        transaction.commit()
    }

    private fun openFile(){
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine { line ->
            val vaccine = parser.parse(line)
            DataManger.addVaccine(vaccine)
        }
        DataManger.getVaccinationMapOfCountry("iraq").log()
        DataManger.getTotalVaccinationForCountry("iraq").log()
        DataManger.getTotalVaccinationForAllCountries().log()
    }

}