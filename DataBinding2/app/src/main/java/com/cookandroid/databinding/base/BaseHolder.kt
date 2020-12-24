package com.cookandroid.databinding.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.databinding.item.ProfileData

class BaseHolder<VB: ViewDataBinding, M: Any>(private val binding: VB) : RecyclerView.ViewHolder(binding.root) {
    lateinit var model: M

    open fun bind(model: M) {
        this.model = model
    }
}