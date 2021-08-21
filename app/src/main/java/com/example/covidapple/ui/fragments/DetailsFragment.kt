package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentDetailsBinding
import com.example.covidapple.databinding.FragmentHomeBinding


class DetailsFragment:BaseFragment<FragmentDetailsBinding>() {
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }
}