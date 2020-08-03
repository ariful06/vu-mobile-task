package com.multithread.vumobiletest.model.repository

import com.multithread.vumobiletest.model.dto.User
import com.multithread.vumobiletest.model.dto.UserResponse
import com.multithread.vumobiletest.util.AppPreference_
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import org.androidannotations.annotations.UiThread
import org.androidannotations.annotations.sharedpreferences.Pref
import retrofit2.Response

@EBean
open class UserAsyncImpl : UserAsync{

    private val userRepository = UserRepository.getInstance()
    @Pref
    lateinit var pref: AppPreference_

    @Background
    override fun getUserFromRemote(currentPage: Int, callback: UserAsync.OnUserCallback) {
        val response  = userRepository.getAllUsers(currentPage)

        if (response != null && response.isSuccessful) {
            pref.currentPage().put(response.body()?.currentPage)
            if (pref.currentPage().get() == response.body()?.totalPages) {
                pref.currentPage().put(0)
            }
            if (response.body()?.userList != null && response.body()?.size!! > 0) {
                val userList: ArrayList<User>? = response.body()?.userList

                getUserFromRemoteAwait(response.body(), currentPage, callback)
            } else
                getUserFromRemoteAwait(response.body(), currentPage, callback)
        }else {
            getUserFromRemoteAwait(null, currentPage, callback)
        }

    }

    @UiThread
    open fun getUserFromRemoteAwait(response: UserResponse?,pageNumber : Int, callback: UserAsync.OnUserCallback) {
        if (response != null) callback.onUserLoaded(response, pageNumber)
        else callback.onUserLoadFinished(pageNumber)
    }

}