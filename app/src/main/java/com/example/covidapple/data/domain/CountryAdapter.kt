package com.example.covidapple.data.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapple.R
import com.example.covidapple.data.DataManger
import com.example.covidapple.databinding.ItemVaccinationBinding

class CountryAdapter(private val list: List<Pair<String?, Int?>>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        //provide the necessary items to show
       val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_vaccination,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        //list that has the current position
        val currentValue = list[position]

      holder.binding.apply {
          textCountryName.text = currentValue.first
          textCountryValue.text =
              currentValue.second?.let { DataManger.abbreviateTheNumber(it.toLong()) }

      }
    }

    override fun getItemCount() = list.size

   class CountryViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem) {
        val binding = ItemVaccinationBinding.bind(viewItem)
   }
}