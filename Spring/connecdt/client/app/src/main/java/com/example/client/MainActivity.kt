package com.example.client

import com.example.client.databinding.ActivityMainBinding
import com.example.client.singleton.FormDataRequest
import com.example.client.singleton.JsonRequest
import com.example.client.singleton.UrlenRequest

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun init() {
        super.init()

        binding.btnJson.setOnClickListener {
            JsonRequest.requestHttp(binding.txt)
        }

        binding.btnFormData.setOnClickListener {
            FormDataRequest.requestHttp(binding.txt)
        }

        binding.btnXWWW.setOnClickListener {
            UrlenRequest.requestHttp(binding.txt)
        }

    }
}