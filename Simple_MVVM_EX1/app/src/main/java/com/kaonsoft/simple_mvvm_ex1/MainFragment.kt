package com.kaonsoft.simple_mvvm_ex1

import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simple_mvvm_ex1.base.BaseFragment
import com.kaonsoft.simple_mvvm_ex1.data.RoomsData
import com.kaonsoft.simple_mvvm_ex1.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    val viewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    override fun init() {
        super.init()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getRoomsData().observe(this, Observer<RoomsData>{
            binding.txt.text = it.toString()
        })
        var input = HashMap<String, Any>()
        input["college"] = "IT"
        viewModel.apiRooms(input)
    }
}
