package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import com.example.covidapple.data.DataManger
import com.example.covidapple.data.domain.CountryAdapter
import com.example.covidapple.databinding.FragmentVaccinationBinding

class VaccinationFragment:BaseFragment<FragmentVaccinationBinding>() {
    override val LOG_TAG: String = "Vaccination Activity"

    override val bindingInflater: (LayoutInflater) -> FragmentVaccinationBinding
        get() = FragmentVaccinationBinding::inflate


    override fun setup() {
        val adapter = CountryAdapter(DataManger.getTotalVaccinatedForAllCountry())
        binding?.countryRecycleView?.adapter=adapter
    }

    override fun addCallBack() {

    }
}