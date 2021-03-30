package com.kaonsoft.mvvmex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaonsoft.mvvmex.databinding.ActivityMainBinding

class MainActivity(override val viewModel: MainViewModel) : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {


//    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        binding.lifecycleOwner = this
    }

    override fun initDataBinding() {
    }

    override fun initAfterBinding() {
    }
}