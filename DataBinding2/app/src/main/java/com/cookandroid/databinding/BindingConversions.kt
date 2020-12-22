package com.cookandroid.databinding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingConversions {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView : ImageView, url : String){

        Glide.with(imageView.context).load(url)
            .into(imageView)
        Log.d("test", imageView.toString() + url)
    }
}