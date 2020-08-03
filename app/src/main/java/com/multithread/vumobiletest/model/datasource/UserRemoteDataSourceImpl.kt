package com.multithread.vumobiletest.model.datasource

import android.util.Log
import com.multithread.vumobiletest.model.dto.UserResponse
import com.multithread.vumobiletest.model.remote.UserEndPoint
import com.multithread.vumobiletest.util.PageConstant
import com.multithread.vumobiletest.webservices.ApiClient
import retrofit2.Response

class UserRemoteDataSourceImpl  : UserRemoteDataSource{

    override fun getAllUsers(pageNumber: Int): Response<UserResponse>? {
        try {
            val response = ApiClient.client
                .create(UserEndPoint::class.java)
                .getUserList(pageNumber, PageConstant.SERVER_SIZE_LIMIT)
                .execute()

            Log.e(TAG," : $response")
            return response
        } catch (e: Exception) {
            Log.e(TAG," : $e")
        }

        return null
    }

    companion object{
        var TAG = "UserRemoteDataSourceImpl"
    }

}