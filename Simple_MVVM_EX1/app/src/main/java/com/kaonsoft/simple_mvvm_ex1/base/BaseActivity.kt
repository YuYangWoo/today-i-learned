package com.kaonsoft.simple_mvvm_ex1.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        init()
    }

    protected open fun init() {
        initViewDataBinding()
    }



    protected open fun initViewDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    protected open fun toast(context: Context,  msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}