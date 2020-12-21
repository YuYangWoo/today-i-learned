package com.cookandroid.databinding

import android.app.Activity
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.cookandroid.databinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    var text1 ="1"
    var text2 = "2"
    var text3 = "3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.main = this


    }

    fun btn1Click(view : View) {
        Toast.makeText(this,"버튼 1 클릭", Toast.LENGTH_SHORT).show()
    }

    fun nextClick(view: View) {
        startActivity(Intent(this, NextActivity::class.java))
    }

}