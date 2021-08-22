package com.example.covidapple.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.widget.TextView
import com.example.covidapple.databinding.FragmentHomeBinding
import com.example.covidapple.util.Data

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "Home Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override fun setup() {
        getData()
    }

    override fun addCallBack() {
        binding?.reedMeButton?.setOnClickListener {
            learnMore()
        }
    }

    private fun learnMore(){
        var readMoreArticle:String = "https://www.hopkinsmedicine.org/health/conditions-and-diseases/coronavirus"
        var intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(readMoreArticle)
        startActivity(intent)
    }

    fun getData(){
        binding?.confirmedNumberTextnember?.setText(Data.CONFIRMED.v)
        binding?.deathsNumber?.setText(Data.DEATHS.v)
        binding?.recoverNumber?.setText(Data.RECOVER.v)
    }
}