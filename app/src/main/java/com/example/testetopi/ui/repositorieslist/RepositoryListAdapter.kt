package com.example.testetopi.ui.repositorieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testetopi.R
import com.example.testetopi.base.BaseListAdapterInterface
import com.example.testetopi.models.RepositoryVO

class RepositoryListAdapter: ListAdapter<RepositoryVO, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<RepositoryVO>() {
        
        override fun areItemsTheSame(oldItem: RepositoryVO, newItem: RepositoryVO) =
            oldItem.repositorieId == newItem.repositorieId

        override fun areContentsTheSame(oldItem: RepositoryVO, newItem: RepositoryVO) =
            oldItem == newItem
    }) {

    var itemClickListener: BaseListAdapterInterface.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RepositoryViewHolder(
            parent.context,
            LayoutInflater.from(parent.context).inflate(
                R.layout.repository_view_holder,
                parent,
                false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            (holder as? RepositoryViewHolder)?.bind(it)
        }
    }

}