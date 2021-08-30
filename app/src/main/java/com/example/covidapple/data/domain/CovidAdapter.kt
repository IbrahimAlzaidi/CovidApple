package com.example.covidapple.data.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapple.R
import com.example.covidapple.data.CovidSymptoms
import com.google.android.material.imageview.ShapeableImageView

class CovidAdapter(private  val  symptomsList: ArrayList<CovidSymptoms>): RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_covid_info, parent, false)
        return CovidViewHolder(view)
    }


    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val symList = symptomsList[position]
        holder.imageSymptoms.setImageResource(symList.symptomsImage)


    }

    override fun getItemCount() = symptomsList.size


    class CovidViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageSymptoms:ShapeableImageView = itemView.findViewById(R.id.image_symptomps)
    }
}

