package com.example.mynewsappwithflow.presentation.screen.infoScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.mynewsappwithflow.R
import com.mashhurbek.myinfoaplication.R
import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
import com.mashhurbek.myinfoaplication.databinding.InfoScreenBinding

class InfoScreen : Fragment(R.layout.info_screen) {

    private val binding: InfoScreenBinding by viewBinding(InfoScreenBinding::bind)
    private lateinit var data: NewsParam

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = arguments?.getSerializable("dataItem") as NewsParam

        loadAction()
    }

    fun loadAction() {
        Glide.with(binding.root)
            .load(data.image)
            .into(binding.newsImage)

        binding.newsDate.text = data.date
        binding.newsTitle.text = data.name
        binding.newsDescription.text = data.desc
        binding.author.text = data.author

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}