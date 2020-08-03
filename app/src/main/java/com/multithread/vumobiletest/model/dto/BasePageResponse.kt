package com.multithread.vumobiletest.model.dto

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.Serializable

abstract class BasePageResponse(
@SerializedName("total_pages")
var totalPages: Int? = null,

@SerializedName("total")
var totalElements: Long? = null,

@SerializedName("per_page")
var size: Int? = null,

@SerializedName("page")
var currentPage: Int? = null

) : Serializable {
    override fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}