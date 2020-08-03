package com.multithread.vumobiletest.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("data")
    @Expose
    var userList: ArrayList<User>? = null
) : BasePageResponse()