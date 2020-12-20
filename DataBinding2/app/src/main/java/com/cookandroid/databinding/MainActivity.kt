package com.cookandroid.databinding

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.cookandroid.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var person1 = Person("양우",24)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.person = person1
        binding.txt3.text = "5"



    }

    data class Person(var name: String, var age:Int)

}