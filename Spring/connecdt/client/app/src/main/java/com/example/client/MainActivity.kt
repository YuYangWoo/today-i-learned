package com.example.client


import android.content.ContentResolver
import android.net.Uri
import com.bumptech.glide.Glide
import com.example.client.databinding.ActivityMainBinding
import com.example.client.singleton.FormDataRequest
import com.example.client.singleton.JsonRequest
import com.example.client.singleton.UrlenRequest


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun init() {
        super.init()
//var a =  Uri.parse("android.resource://com.example.client/drawable/icon")




        binding.btnJson.setOnClickListener {
            JsonRequest.requestHttp(binding.txt)
        }

        binding.btnFormData.setOnClickListener {
            FormDataRequest.test(this, binding)
        }

        binding.btnXWWW.setOnClickListener {
            UrlenRequest.requestHttp(binding.txt)
        }

    }
}