package com.multithread.vumobiletest.model.datasource

import com.multithread.vumobiletest.model.dto.UserResponse
import retrofit2.Response

interface UserRemoteDataSource{
    fun getAllUsers(pageNumber: Int): Response<UserResponse>?
}