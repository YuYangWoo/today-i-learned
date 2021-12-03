package com.example.ui.main.activity

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Word
import com.example.ui.main.base.BaseActivity
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.ui.adapter.WordListAdapter
import com.example.ui.viewmodel.WordViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val newWordActivityRequestCode = 1
    private val wordViewModel: WordViewModel by viewModel()
    val wordAdapter = WordListAdapter()
    override fun init() {
        super.init()
        recyclerView()
        observeViewModel()
        btnClick()
    }

    private fun btnClick() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }

    private fun recyclerView() {
        with(binding.recyclerview) {
            adapter = wordAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                wordAdapter.removeTask(viewHolder.adapterPosition)
            }

        }).apply {
            attachToRecyclerView(binding.recyclerview)
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                wordAdapter.removeTask(viewHolder.adapterPosition)
            }

        }).apply {
            attachToRecyclerView(binding.recyclerview)
        }

    }

    private fun observeViewModel() {
        wordViewModel.allWords.observe(this, Observer { words ->
            words.let {
                wordAdapter.data = wordViewModel.allWords.value as ArrayList<Word>
                wordAdapter.submitList(wordViewModel.allWords.value as ArrayList<Word>)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(it)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }

}