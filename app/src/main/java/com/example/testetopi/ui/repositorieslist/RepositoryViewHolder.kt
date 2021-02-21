package com.example.testetopi.ui.repositorieslist

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testetopi.R
import com.example.testetopi.base.BaseListAdapterInterface
import com.example.testetopi.models.RepositoryVO

class RepositoryViewHolder (
    private val context: Context,
    view: View,
    private val itemClickListener: BaseListAdapterInterface.OnItemClickListener?
): RecyclerView.ViewHolder(view), View.OnClickListener{

    init {
        itemView.setOnClickListener(this)
        itemView.findViewById<View>(R.id.view_holder_repositories_list_click_overlay)?.setOnClickListener(this)
    }

    private val viewHolderRepositoryImageViewOwnerAvatar = itemView.findViewById<ImageView>(R.id.view_holder_repository_image_view_owner_avatar)
    private val viewHolderRepositoryTextViewOwnerName = itemView.findViewById<TextView>(R.id.view_holder_repository_text_view_owner_name)
    private val viewHolderRepositoryTextViewRepositoryName = itemView.findViewById<TextView>(R.id.view_holder_repository_text_view_repository_name)
    private val viewHolderRepositoryTextViewRepositoryDescription = itemView.findViewById<TextView>(R.id.view_holder_repository_text_view_repository_description)
    private val viewHolderRepositoryTextViewForksNumber = itemView.findViewById<TextView>(R.id.view_holder_repository_text_view_forks_number)
    private val viewHolderRepositoryTextViewStarsNumber = itemView.findViewById<TextView>(R.id.view_holder_repository_text_view_stars_number)

    fun bind(repository: RepositoryVO) {

        Glide.with(context).load(repository.repositorieOwner.ownerAvatarUrl).into(viewHolderRepositoryImageViewOwnerAvatar)

        viewHolderRepositoryTextViewOwnerName.text = repository.repositorieOwner.ownwerName
        viewHolderRepositoryTextViewRepositoryName.text = repository.repositorieName
        viewHolderRepositoryTextViewRepositoryDescription.text = repository.repositorieDescription
        viewHolderRepositoryTextViewForksNumber.text = repository.repositorieForksCount.toString()
        viewHolderRepositoryTextViewStarsNumber.text = repository.repositorieStargazersCount.toString()
    }

    override fun onClick(viewClickedOn: View?) {
        viewClickedOn?.let {
            itemClickListener?.onItemClick(adapterPosition, viewClickedOn)
        }
    }
}