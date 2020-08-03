package com.multithread.vumobiletest.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.multithread.vumobiletest.R

object ImageBinder{

    @JvmStatic
    @BindingAdapter("app:src")
    fun setImageResource(imageView: ImageView, url:String) {
        Glide.with(imageView.context).load(url).centerCrop()
            .placeholder(R.drawable.default_img)
            .into(imageView)
    }

}