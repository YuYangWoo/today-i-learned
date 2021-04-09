package com.kaonsoft.simple_mvvm_ex1.ui.main.view.fragment

import android.content.Intent
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kaonsoft.simple_mvvm_ex1.R
import com.kaonsoft.simple_mvvm_ex1.data.model.Information
import com.kaonsoft.simple_mvvm_ex1.ui.base.BaseFragment
import com.kaonsoft.simple_mvvm_ex1.data.model.RoomsData
import com.kaonsoft.simple_mvvm_ex1.data.repository.LoginRepository
import com.kaonsoft.simple_mvvm_ex1.data.sigleton.MySharedPreferences
import com.kaonsoft.simple_mvvm_ex1.databinding.FragmentMainBinding
import com.kaonsoft.simple_mvvm_ex1.ui.main.view.activity.LoginActivity
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.LoginActivityViewModel
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.LoginActivityViewModelFactory
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.MainActivityViewModel

//import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.MainActivityViewModel

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModelFactory by lazy {
        LoginActivityViewModelFactory(LoginRepository())
    }

    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(LoginActivityViewModel::class.java)
    }
    override fun init() {
        super.init()
        initViewModel()
        btn()
        logout()
    }

    private fun btn() {
        binding.btn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment())
        }
    }

    private fun initViewModel() {
//        viewModel.roomsData.observe(requireActivity(), Observer<RoomsData>{
//            binding.txt.text = it.toString()
//        })
//        var input = HashMap<String, Any>()
//        input["college"] = "IT"
//        viewModel.apiRooms(input)

        viewModel.loginData.observe(requireActivity(), Observer<Information> {
            Log.d("TAG", it.toString() + "dd")
        })

    }

    private fun logout() {
        binding.btnLogout.setOnClickListener {
            MySharedPreferences.clearUser(requireContext())
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            toast(requireContext(), "로그아웃 되었습니다.")
            requireActivity().finish()
        }
    }

}
