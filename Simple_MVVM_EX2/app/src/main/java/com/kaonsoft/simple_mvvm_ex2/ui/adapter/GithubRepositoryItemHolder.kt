package com.kaonsoft.simple_mvvm_ex2.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kaonsoft.simple_mvvm_ex2.data.model.GithubRepositoryModel
import kotlinx.android.synthetic.main.item_github_repository.view.*

class GithubRepositoryItemHolder(
    view: View, listener: GithubRepositoryAdapter.OnGithubRepositoryClickListener?
) : RecyclerView.ViewHolder(view) {
    private val avatarView: ImageView = view.avatarView
    private val fullNameView: TextView = view.fullNameView
    private val descriptionView: TextView = view.descriptionView
    private val starCountView: TextView = view.starCountView

    init {
        view.setOnClickListener {
            listener?.onItemClick(adapterPosition)
        }
    }

    fun bind(model: GithubRepositoryModel) {
        model.run {
//            avatarView.setImageWithGlide(owner.avatarUrl)
            Glide.with(itemView).load(owner.avatarUrl).into(avatarView)
            fullNameView.text = fullName
            descriptionView.text = description
            starCountView.text = "Stars : $stargazersCount"
        }
    }
}

