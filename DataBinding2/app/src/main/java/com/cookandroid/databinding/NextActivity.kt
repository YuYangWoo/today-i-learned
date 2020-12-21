package com.cookandroid.databinding

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.databinding.databinding.ActivityNextBinding

class NextActivity:BaseActivity<ActivityNextBinding>(R.layout.activity_next) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.next = this
        setRcv()

    }

    fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data = arrayListOf(
            ProfileData("유양우",24),
            ProfileData("김예림",23)
        )
        profileAdapter.notifyDataSetChanged()
    }


}