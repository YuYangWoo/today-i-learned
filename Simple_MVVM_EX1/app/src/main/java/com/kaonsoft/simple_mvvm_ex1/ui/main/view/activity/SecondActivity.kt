package com.kaonsoft.simple_mvvm_ex1.ui.main.view.activity

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simple_mvvm_ex1.R
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import com.kaonsoft.simple_mvvm_ex1.databinding.ActivitySecondBinding
import com.kaonsoft.simple_mvvm_ex1.ui.base.BaseActivity
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.MainActivityViewModel

class SecondActivity : BaseActivity<ActivitySecondBinding>(R.layout.activity_second) {
    private val viewModel by lazy {
        ViewModelProvider(this@SecondActivity).get(MainActivityViewModel::class.java)
    }
    override fun init() {
        super.init()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.roomsData.observe(this@SecondActivity, Observer<RoomsData> {
            Log.d("TAG", it.toString())
            binding.txt.text = it.toString()
        })

    }
}