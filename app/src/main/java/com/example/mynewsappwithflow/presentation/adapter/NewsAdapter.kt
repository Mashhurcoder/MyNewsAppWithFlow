package com.mashhurbek.myinfoaplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynewsappwithflow.data.remote.model.param.NewsParam
import com.mashhurbek.myinfoaplication.databinding.NewsItemBinding

class NewsAdapter : ListAdapter<NewsParam, NewsAdapter.NewsViewHolder>(NewsDiffUtil) {

    var itemClick: ((NewsParam) -> Unit)? = null

    object NewsDiffUtil : DiffUtil.ItemCallback<NewsParam>() {
        override fun areItemsTheSame(
            oldItem: NewsParam,
            newItem: NewsParam
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewsParam,
            newItem: NewsParam
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class NewsViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClick?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind(newsParam: NewsParam) {
            binding.itemTitle.text = newsParam.name
            binding.itemDescription.text = newsParam.desc
            Glide.with(binding.root)
                .load(newsParam.image)
                .into(binding.itemImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}