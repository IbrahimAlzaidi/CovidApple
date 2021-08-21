package com.example.covidapple.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.transition.TransitionManager
import com.example.covidapple.databinding.FragmentDetailsBinding
import com.example.covidapple.databinding.FragmentHomeBinding


class DetailsFragment:BaseFragment<FragmentDetailsBinding>() {
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        addExpandAbilty(binding?.textView, binding?.readMoreSymptomps)
    }

    override fun addCallBack() {

    }



    private fun addExpandAbilty(detailsText : TextView?, readMeView : TextView?){

       readMeView?.setOnClickListener {
           val isExpand = detailsText?.maxLines == Int.MAX_VALUE
            TransitionManager.beginDelayedTransition(binding?.root as ViewGroup)
            detailsText?.maxLines = if (isExpand) 2 else Int.MAX_VALUE
            readMeView?.text = if (isExpand) "Read more" else "Show less"
       }

    }
}