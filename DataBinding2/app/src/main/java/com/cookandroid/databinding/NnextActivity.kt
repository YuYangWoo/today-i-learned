package com.cookandroid.databinding

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.databinding.base.BaseActivity
import com.cookandroid.databinding.databinding.ActivityNnextBinding

class NnextActivity : BaseActivity<ActivityNnextBinding>(R.layout.activity_nnext) {
    private val model by lazy {ViewModelProvider(this).get(NextViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = model

    }
    class NextViewModel : ViewModel() {
        var count = MutableLiveData<Int>()
        init {
            count.value =0
        }

        fun increase() {
            count.value =  count.value?.plus(1)
        }

        fun decrease() {
            count.value = count.value?.minus(1)
        }
    }


}