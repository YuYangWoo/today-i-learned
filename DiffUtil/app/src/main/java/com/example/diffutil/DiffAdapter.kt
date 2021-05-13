package com.example.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.HolderWordBinding

class DiffAdapter constructor() : RecyclerView.Adapter<DiffAdapter.ViewHolder>() {
    private var dataList = ArrayList<String>()
    constructor(data: ArrayList<String>): this() {
        this.dataList = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffAdapter.ViewHolder {
        val binding = HolderWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiffAdapter.ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    inner class ViewHolder(private val binding: HolderWordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(a: String) {
            binding.diff = a
        }
    }
}