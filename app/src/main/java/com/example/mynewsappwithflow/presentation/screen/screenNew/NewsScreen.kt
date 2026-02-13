package com.example.mynewsappwithflow.presentation.screen.screenNew

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mynewsappwithflow.R
import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
import com.example.mynewsappwithflow.databinding.MainScreenBinding
import com.mashhurbek.myinfoaplication.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsScreen : Fragment(R.layout.main_screen) {
    private val adapter by lazy { NewsAdapter() }
    private val viewmodel: NewsViewModel by viewModels<NewsViewModelImpl>()
    private val viewBinding by viewBinding(MainScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.recyclerView.adapter = adapter
        viewmodel.newsList.observe(viewLifecycleOwner, newsListObserver)
        viewmodel.loadList()
        loadAction()

        adapter.itemClick = {data->
            findNavController().navigate(R.id.action_newsScreen_to_infoScreen, bundleOf("dataItem" to data))
        }
    }

    private val newsListObserver = Observer<List<NewsParam>> {
        Log.d("TTT", ":$it ")
        adapter.submitList(it)
    }

    fun loadAction() {
        viewBinding.search.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 != null) {
                    if (p0.isEmpty()) {
                        viewmodel.searchViews(p0)
                    }
                }
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewmodel.searchViews(p0 ?: "")
                return true
            }
        })
    }
}