package com.cookandroid.databinding.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.databinding.item.ProfileData
import com.cookandroid.databinding.databinding.RcvListItemBinding

class ProfileAdapter(private val context: Context) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    var data = ArrayList<ProfileData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding = RcvListItemBinding.inflate(
                LayoutInflater.from(context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ProfileViewHolder(private val binding: RcvListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ProfileData) {
            binding.user = data
        }
    }
}