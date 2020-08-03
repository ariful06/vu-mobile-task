package com.multithread.vumobiletest.model.repository

import com.multithread.vumobiletest.model.datasource.UserRemoteDataSource
import com.multithread.vumobiletest.model.datasource.UserRemoteDataSourceImpl
import com.multithread.vumobiletest.model.dto.UserResponse
import retrofit2.Response

class UserRepository : UserRemoteDataSource{

    companion object {
        private var userRepository: UserRepository? = null
        private var remoteDataSource: UserRemoteDataSource = UserRemoteDataSourceImpl()

        @Synchronized
        @JvmStatic
        fun getInstance(): UserRepository {
            if (userRepository == null)
                userRepository = UserRepository()
            return userRepository!!
        }
    }

    override fun getAllUsers(pageNumber: Int): Response<UserResponse>? {
        return remoteDataSource.getAllUsers(pageNumber)
    }

}