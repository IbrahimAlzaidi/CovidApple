package com.example.covidapple.ui.fragments

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.example.covidapple.databinding.FragmentHomeBinding
import com.example.covidapple.databinding.FragmentInfoBinding

class InfoFragment:BaseFragment<FragmentInfoBinding>() {
    override val LOG_TAG: String = "Info Fragment"
    override val bindingInflater: (LayoutInflater) -> FragmentInfoBinding
        get() = FragmentInfoBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {
        var url:String
        binding?.buttonGithubRafal?.setOnClickListener{
                url="https://github.com/Rafal-a"
                gitHubAccount(url)
        }
        binding?.buttonGithubIbrahim?.setOnClickListener {
            url = "https://github.com/IbrahimAlzaidi"
            gitHubAccount(url)
        }
        binding?.buttonGithubAymn?.setOnClickListener {
            url = "https://github.com/juck0"
            gitHubAccount(url)
        }
        binding?.buttonGithubBasheer?.setOnClickListener {
            url = "https://github.com/MoeZalzala"
            gitHubAccount(url)
        }
        binding?.buttonGithubHuda?.setOnClickListener {
            url = "https://github.com/asawerdawood"
            gitHubAccount(url)
        }
    }
    private fun gitHubAccount(url:String){
        var intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}