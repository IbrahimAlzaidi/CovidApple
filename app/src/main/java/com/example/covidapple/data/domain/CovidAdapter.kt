package com.example.covidapple.data.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapple.R
import com.example.covidapple.data.CovidSymptoms
import com.example.covidapple.databinding.ItemCovidInfoBinding
import com.example.covidapple.databinding.ItemVaccienesBinding
import com.google.android.material.imageview.ShapeableImageView

class CovidAdapter(private val symptomsList: ArrayList<CovidSymptoms>): RecyclerView.Adapter<CovidAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_covid_info, parent, false)
        return CovidViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val symList = symptomsList[position]
        when(holder){
            is CovidViewHolder ->{
                holder.binding.imageSymptomps.setImageResource(symList.symptomsImage)

            }
            is CovidVaccineHolder -> {
                holder.binding.imageVacciene.setImageResource(symList.symptomsImage)
            }
        }


    }

    override fun getItemCount() = symptomsList.size

    abstract class BaseViewHolder(viewItem:View):RecyclerView.ViewHolder(viewItem)
    class CovidViewHolder(private val itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemCovidInfoBinding.bind(itemView)
    }
    class CovidVaccineHolder(private val itemView:View):BaseViewHolder(itemView){
      val binding = ItemVaccienesBinding.bind(itemView)
    }
    companion object{
        const val VIEW_TYPE_TYPE_OF_VACCIENE = 16
        const val VIEW_TYPE_COVID_INFO = 17
    }
}

