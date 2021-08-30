package com.example.covidapple.ui.fragments

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import com.example.covidapple.data.DataManger

import com.example.covidapple.databinding.FragmentSearchBinding
import org.eazegraph.lib.models.BarModel
import org.eazegraph.lib.models.PieModel
import kotlin.random.Random

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
    }

    private fun search(country: String): Boolean {
        binding?.apply {
            binding?.barchart?.visibility = View.VISIBLE
             DataManger.getVaccinationMapOfCountry(country).forEach { (t, u) ->
                    binding?.barchart?.addBar(u?.toFloat()?.let {
                    BarModel(t,
                        it, Color.argb(255, Random.nextInt(50, 200),
                            Random.nextInt(50, 250), Random.nextInt(50, 250)))
                })
            }
            binding?.barchart?.startAnimation()
        }
        return false
    }
}