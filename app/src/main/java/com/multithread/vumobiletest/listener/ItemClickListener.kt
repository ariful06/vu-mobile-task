package com.multithread.vumobiletest.listener

import com.multithread.vumobiletest.model.dto.User

interface ItemClickListener {
    fun onUserClicked(user : User)
}