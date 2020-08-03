package com.multithread.vumobiletest.model.dto

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("first_name")
    @Expose
    var firstName: String? = null,

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null,

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
) : Serializable{
    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }

    fun getFullName(): String = "$firstName $lastName"
}