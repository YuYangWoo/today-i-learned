package com.example.ui.main.activity

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.di.MyApplication
import com.example.data.model.Word
import com.example.ui.main.base.BaseActivity
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.ui.adapter.WordListAdapter
import com.example.ui.viewmodel.WordViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.activity.viewModels
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val newWordActivityRequestCode = 1
//    private val wordViewModel: WordViewModel by viewModels {
//        WordViewModel.WordViewModelFactory((application as MyApplication).repository)
//    }

    private val wordViewModel: WordViewModel by viewModel()
    override fun init() {
        super.init()
        val adapter = WordListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        wordViewModel.allWords.observe(this, Observer { words ->
            words.let {
                adapter.submitList(it)
            }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

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