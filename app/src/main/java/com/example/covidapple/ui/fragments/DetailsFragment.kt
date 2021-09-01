package com.example.covidapple.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
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
        setSymptompsInfo()
        setPreventionInfo()
        setVaccieneInfo()
    }

    private fun setPreventionInfo() {
        imageId= arrayOf(
            R.drawable.ic_wash_hands,
            R.drawable.ic_wear_face_mask,
            R.drawable.ic_clean_surfaces,
            R.drawable.ic_distance,
        )
        binding?.symptomsRecycleView?.setHasFixedSize(true)
        arrayList= arrayListOf<CovidSymptoms>()
        getPreventionData()
    }

    private  fun setSymptompsInfo(){
        imageId= arrayOf(
            R.drawable.ic_cough,
            R.drawable.ic_fever,
            R.drawable.ic_headache,
            R.drawable.ic_muscle_pain
        )
        binding?.symptomsRecycleView?.setHasFixedSize(true)
        arrayList= arrayListOf<CovidSymptoms>()
       getSymptompsData()
    }
    private  fun setVaccieneInfo(){
        imageId= arrayOf(
            R.drawable.vacciene_pfizer,
            R.drawable.vacciene_johnson_and_johnson,
            R.drawable.vacciene_green_apple,
            R.drawable.vacciene_sinopharm,
            R.drawable.vacciene_moderna,
        )
        binding?.vaccineRecycleView?.setHasFixedSize(true)
        arrayList= arrayListOf<CovidSymptoms>()
        getVaccieneData()
    }

    private fun getSymptompsData() {
        imageId.forEachIndexed { index, i ->
            val image = CovidSymptoms(imageId[index])
            arrayList.add(image)
        }
        binding?.symptomsRecycleView?.adapter=CovidAdapter(arrayList)
    }
    private fun getPreventionData() {
        imageId.forEachIndexed { index, i ->
            val image = CovidSymptoms(imageId[index])
            arrayList.add(image)
        }
        binding?.preventionRecyclerView?.adapter=CovidAdapter(arrayList)
    }
    private fun getVaccieneData() {
        imageId.forEachIndexed { index, i ->
            val image = CovidSymptoms(imageId[index])
            arrayList.add(image)
        }
        binding?.vaccineRecycleView?.adapter=CovidAdapter(arrayList)
    }

    override fun addCallBack() {
        binding?.buttonKnowMoreSymptoms!!.setOnClickListener {
            val symptomsUrl ="https://www.cdc.gov/coronavirus/2019-ncov/symptoms-testing/symptoms.html"
            showArticle(symptomsUrl)
        }
        binding?.buttonKnowMorePrevention!!.setOnClickListener {
            val preventionUrl = "https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html"
            showArticle(preventionUrl)
        }

    }

    private fun showArticle(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data= Uri.parse(url)
        startActivity(intent)

    }


}