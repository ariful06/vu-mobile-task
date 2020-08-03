package com.multithread.vumobiletest.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.multithread.vumobiletest.adapter.UserListAdapter
import com.multithread.vumobiletest.model.dto.User

object ListBinder {

        @JvmStatic
        @BindingAdapter("app:user_items")
        fun setUserListItems(recyclerView: RecyclerView, items: List<User>) {
            (recyclerView.adapter as UserListAdapter?)?.replaceData(items)
        }
}