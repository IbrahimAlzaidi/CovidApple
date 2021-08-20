package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentSearchBinding

class SearchFragment:BaseFragment<FragmentSearchBinding>() {
    override val LOG_TAG: String = "Search Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {

    }
}