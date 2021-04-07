package com.kaonsoft.simple_mvvm_ex1.ui.main.view.fragment

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simple_mvvm_ex1.R
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import com.kaonsoft.simple_mvvm_ex1.databinding.FragmentSecondBinding
import com.kaonsoft.simple_mvvm_ex1.ui.base.BaseFragment
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.MainActivityViewModel

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun init() {
        super.init()
        initViewModel()
        btn()
    }

    private fun btn() {
        binding.btn.setOnClickListener {
        }
    }
    private fun initViewModel() {
        viewModel.roomsData.observe(requireActivity(), Observer<RoomsData> {
            binding.txt.text = it.toString()
        })
//        var input = HashMap<String, Any>()
//        input["college"] = "IT"
//        viewModel.apiRooms(input)

    }
}