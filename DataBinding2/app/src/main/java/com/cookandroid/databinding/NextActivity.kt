package com.cookandroid.databinding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.databinding.Adapter.ProfileAdapter
import com.cookandroid.databinding.base.BaseActivity
import com.cookandroid.databinding.databinding.ActivityNextBinding
import com.cookandroid.databinding.item.ProfileData

class NextActivity: BaseActivity<ActivityNextBinding>(R.layout.activity_next) {
    var next = "livedata+viewmodel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.next = this
        binding.nnextButton.text = next
        setRcv()

    }

    fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter
        profileAdapter.data = arrayListOf(
            ProfileData("유양우",24,"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbopEgE%2FbtqOxrB6VSb%2F98ISU1D9wCTABcJq9guGj1%2Fimg.png"),
            ProfileData("김예림",23,"https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbopEgE%2FbtqOxrB6VSb%2F98ISU1D9wCTABcJq9guGj1%2Fimg.png")
        )
        profileAdapter.notifyDataSetChanged()
    }
    fun nnextBtn(view: View) {
        startActivity(Intent(this, NnextActivity::class.java))
    }


}