package com.example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Word
import com.example.roomdb.databinding.RecyclerviewItemBinding

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    var data = ArrayList<Word>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListAdapter.WordViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun removeTask(position: Int) {
        data.removeAt(position)
        notifyDataSetChanged()
    }
    inner class WordViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(a: Word) {
            binding.word = a
        }

    }
}