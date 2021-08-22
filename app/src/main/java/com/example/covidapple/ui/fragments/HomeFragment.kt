package com.example.covidapple.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentHomeBinding

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "Home Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate
    override fun setup() {

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
}