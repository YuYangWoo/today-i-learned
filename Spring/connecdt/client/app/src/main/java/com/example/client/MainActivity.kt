package com.example.client

import android.util.Log
import com.example.client.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun init() {
        super.init()

        binding.btnJson.setOnClickListener {
            JsonRequest.requestHttp(binding.txt)
        }

        binding.btnFormData.setOnClickListener {
            UrlenRequest.requestHttp(binding.txt)
        }

        binding.btnXWWW.setOnClickListener {
            UrlenRequest.requestHttp(binding.txt)
        }

    }
}