package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import com.example.covidapple.data.DataManger

import com.example.covidapple.databinding.FragmentSearchBinding
import com.example.covidapple.util.Helper
import org.eazegraph.lib.models.BarModel

class SearchFragment:BaseFragment<FragmentSearchBinding>() {
    override val LOG_TAG: String = "Search Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {
        binding?.barchart?.visibility = View.INVISIBLE
    }

    override fun addCallBack() {

        binding!!.apply {
            search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                //click search icon in keyboard
                override fun onQueryTextSubmit(query: String) = search(query)
                override fun onQueryTextChange(newText: String?) = false
            })
            search.queryHint = "Looking for Country, Type it's Name"
        }

        binding?.totalVaccinationChip?.setOnClickListener {
//            binding?.totalVaccinationCardData?.text = Helper.abbreviateTheNumber(DataManger.getTotalVaccinationForAllCountries())
        }
        binding?.peopleVaccinatedChip?.setOnClickListener {
        }
        binding?.peopleFullyVaccinatedChip?.setOnClickListener {
        }

    }

    private fun search(country: String): Boolean {
        binding?.apply {
            binding?.barchart?.visibility = View.VISIBLE
             DataManger.getVaccinationMapOfCountry(country).forEach { (k, v) ->
                    binding?.barchart?.addBar(v?.toFloat()?.let {
                    BarModel(k,
                        it, Helper.colorSet()
                    )
                })
            }
            binding?.barchart?.startAnimation()
        }
        return false
    }


}