package com.example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Word
import com.example.roomdb.databinding.RecyclerviewItemBinding
import com.example.util.MyDiffCallback

class WordListAdapter :  ListAdapter<Word, WordListAdapter.WordViewHolder>(MyDiffCallback) {
    var data = ArrayList<Word>()

    fun removeTask(position: Int) {
        data.removeAt(position)
    }

    inner class WordViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: Word) {
            binding.word = word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        holder.bind(data[position])
    }

}