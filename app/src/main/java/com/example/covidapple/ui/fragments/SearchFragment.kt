package com.example.covidapple.ui.fragments

import android.graphics.Color
import android.view.LayoutInflater
import android.widget.SearchView
import com.example.covidapple.data.DataManger
import com.example.covidapple.databinding.FragmentSearchBinding
import org.eazegraph.lib.models.PieModel
import kotlin.random.Random

class SearchFragment:BaseFragment<FragmentSearchBinding>() {
    override val LOG_TAG: String = "Search Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {

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
    }

    private fun search(country: String): Boolean {
        binding?.apply {
             DataManger.getVaccinationMapOfCountry(country).forEach { (t, u) ->
                binding?.pieChart?.addPieSlice(u?.toFloat()?.let {
                    PieModel(t,
                        it, Color.argb(255, Random.nextInt(0, 255), Random.nextInt(0, 255), Random.nextInt(0, 255)))
                })
            }
            binding?.pieChart?.startAnimation()

        }
        return false
    }

}