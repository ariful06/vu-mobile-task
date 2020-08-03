package com.multithread.vumobiletest.model.remote

import com.multithread.vumobiletest.model.dto.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserEndPoint {

    @GET("api/users")
    fun getUserList(@Query("page" ) page : Int?,@Query("per_page") perPage : Int) : Call<UserResponse>
}