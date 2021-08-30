package com.example.covidapple.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionManager
import com.example.covidapple.R
import com.example.covidapple.data.CovidSymptoms
import com.example.covidapple.data.domain.CovidAdapter
import com.example.covidapple.databinding.FragmentDetailsBinding


class DetailsFragment:BaseFragment<FragmentDetailsBinding>() {
    lateinit var imageId:Array<Int>
    lateinit var arrayList:ArrayList<CovidSymptoms>
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        imageId= arrayOf(
            R.drawable.cough,
            R.drawable.fever,
            R.drawable.headache,
            R.drawable.muscle_pain
        )
        binding?.symptomsRecycleView?.setHasFixedSize(true)
        arrayList= arrayListOf<CovidSymptoms>()
        getData()
    }

    private fun getData() {
        imageId.forEachIndexed { index, i ->
            val image = CovidSymptoms(imageId[index])
            arrayList.add(image)
        }
        binding?.symptomsRecycleView?.adapter=CovidAdapter(arrayList)
    }

    override fun addCallBack() {
        binding?.buttonKnowMoreSymptoms!!.setOnClickListener {
            val url ="https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html"
            showArticle(url)
        }

    }

    private fun showArticle(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data= Uri.parse(url)
        startActivity(intent)

    }


}