package com.multithread.vumobiletest.model.repository

import com.multithread.vumobiletest.model.dto.UserResponse

interface UserAsync {
    interface OnUserCallback{
        fun onUserLoaded(userResponse : UserResponse, pageNum : Int)
        fun onUserLoadFinished(pageNumber : Int)
    }
    fun getUserFromRemote(currentPage :Int, callback: OnUserCallback)
}