package com.cookandroid.databinding.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M: Any> : RecyclerView.Adapter<BaseHolder<*, M>>() {

}