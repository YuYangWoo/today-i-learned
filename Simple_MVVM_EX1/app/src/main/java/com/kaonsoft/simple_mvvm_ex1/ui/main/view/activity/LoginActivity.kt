package com.kaonsoft.simple_mvvm_ex1.ui.main.view.activity

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import androidx.lifecycle.ViewModelProvider

import com.kaonsoft.simple_mvvm_ex1.R
import com.kaonsoft.simple_mvvm_ex1.data.model.Information
import com.kaonsoft.simple_mvvm_ex1.data.repository.LoginRepository
import com.kaonsoft.simple_mvvm_ex1.data.sigleton.MySharedPreferences
import com.kaonsoft.simple_mvvm_ex1.databinding.ActivityLoginBinding
import com.kaonsoft.simple_mvvm_ex1.ui.base.BaseActivity
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.LoginActivityViewModel
import com.kaonsoft.simple_mvvm_ex1.ui.main.viewmodel.LoginActivityViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val TAG = "MAIN"
    private val viewModelFactory by lazy {
        LoginActivityViewModelFactory(LoginRepository())
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginActivityViewModel::class.java)
    }
    private var userData = Information()
    override fun init() {
        super.init()
        checkAutoLogin()
        btnLogin()
        checkBox()
        initViewModel()

    }

    private fun checkAutoLogin() {
        // 로그인요청을해주고 result가 true면 그때넘어가야함
        // 로그인할 때마다 가져온거.
        // 체크되어있다면 메인화면으로
        if (MySharedPreferences.getCheck(this)) {
            binding.edtId.setText(MySharedPreferences.getUserId(this))
            binding.edtPassword.setText(MySharedPreferences.getUserPass(this))
            binding.checkBox.isChecked = true
            loginApi()
        }
    }

    private fun initViewModel() {
        viewModel.loginData.observe(this) {
            userData = it
            when {
                userData.result -> {
                    loginApi()
                    Log.d("TAG", "로그인성공")
                }
                else -> {
                    toast(this@LoginActivity, userData.response)
                }
            }
        }
    }
    // 체크박스가 체크되어있는지 체크되어 있지 않은지
    private fun checkBox() {
        binding.checkBox.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked) {
                MySharedPreferences.setCheck(this, binding.checkBox.isChecked)
            } else {
                MySharedPreferences.setCheck(this, binding.checkBox.isChecked)
                MySharedPreferences.clearUser(this)
            }
        }
    }

    // 로그인 버튼 클릭
    private fun btnLogin() {
        binding.btnLogin.setOnClickListener {
            var input = HashMap<String, Any>()
            input["id"] = binding.edtId.text.toString()
            input["password"] = binding.edtPassword.text.toString()
            viewModel.loginRepository(input)
        }
    }

    private fun loginApi() {
        val dialog = ProgressDialog(this@LoginActivity).apply {
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            show()
        }
        if (userData.account.type == "STUDENT" && userData.result) {
            toast(this@LoginActivity, "${userData.account.id}님 ${resources.getString(R.string.confirm_login)}")
            MySharedPreferences.setUserId(this@LoginActivity, binding.edtId.text.toString())
            MySharedPreferences.setUserPass(this@LoginActivity, binding.edtPassword.text.toString())
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//            MySharedPreferences.setInformation(this@LoginActivity, userData.account.type,userData.account.department, userData.account.studentId, userData.account.studentName, userData.account.college)
            finish()
        }
        dialog.dismiss()
    }



    }

