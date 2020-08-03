package com.multithread.vumobiletest.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.multithread.vumobiletest.model.dto.User

class FullImageViewModel(application: Application) : AndroidViewModel(application){

    var userDetails : ObservableField<User>?= null
    init {
        userDetails= ObservableField()
    }

    fun start(user : User?){
        if (user == null)
             return
        userDetails?.set(user)
    }
}