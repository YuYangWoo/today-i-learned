package com.kaonsoft.livedata

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.livedata.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        var model = ViewModelProvider(this).get(CounterViewModel::class.java)
       binding.viewModel = model

//        binding.fabAdd.setOnClickListener {
//            model.increase()
//        }
//        binding.fabRemove.setOnClickListener {
//            model.decrease()
//        }
//        model.counter.observe(this, Observer {
//            binding.counterTextView.text = it.toString()
//        })


    }
}