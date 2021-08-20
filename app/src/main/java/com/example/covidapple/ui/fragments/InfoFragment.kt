package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentHomeBinding
import com.example.covidapple.databinding.FragmentInfoBinding

class InfoFragment:BaseFragment<FragmentInfoBinding>() {
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentInfoBinding
        get() = FragmentInfoBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }
}