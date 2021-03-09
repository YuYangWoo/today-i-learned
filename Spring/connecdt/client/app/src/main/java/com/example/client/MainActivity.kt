package com.example.client

import android.net.Uri
import android.util.Log
import com.bumptech.glide.Glide
import com.example.client.databinding.ActivityMainBinding
import com.example.client.singleton.FormDataRequest
import com.example.client.singleton.JsonRequest
import com.example.client.singleton.UrlenRequest

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun init() {
        super.init()
//var a =  Uri.parse("android.resource://com.example.client/drawable/icon")

        Glide.with(this).load(("android.resource://com.example.client/drawable/icon")).into(binding.img)


        binding.btnJson.setOnClickListener {
            JsonRequest.requestHttp(binding.txt)
        }

        binding.btnFormData.setOnClickListener {
            FormDataRequest.test()
        }

        binding.btnXWWW.setOnClickListener {
            UrlenRequest.requestHttp(binding.txt)
        }

    }
}