package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentHomeBinding

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    override val LOG_TAG: String = "Home Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }
}