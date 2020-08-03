package com.multithread.vumobiletest.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.AndroidViewModel
import com.multithread.vumobiletest.event.SingleLiveEventKotlin
import com.multithread.vumobiletest.model.dto.User
import com.multithread.vumobiletest.model.dto.UserResponse
import com.multithread.vumobiletest.model.repository.UserAsync
import com.multithread.vumobiletest.model.repository.UserAsyncImpl_
import com.multithread.vumobiletest.util.AppPreference_

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var userAsync: UserAsync? = null
    var currentPage = 0
    var totalPages = 0
    private var isAlreadyFromZeroPosition: Boolean = false
    var userItemClickSingleLiveEvent : SingleLiveEventKotlin<User>? =null

    var userList : ObservableList<User>  ? = null

    var isLoading: ObservableField<Boolean>? = null
    var pagePref: AppPreference_ = AppPreference_(application)

    init {
        userAsync = UserAsyncImpl_.getInstance_(application)
        isLoading = ObservableField(false)
        userList = ObservableArrayList()
        userItemClickSingleLiveEvent = SingleLiveEventKotlin()
    }

    fun start(){
        userList?.clear()
        currentPage = 1
        fetchUserList(currentPage)
    }

    fun fetchUserList(page: Int) {
        isLoading?.set(true)
            userAsync?.getUserFromRemote(currentPage, object : UserAsync.OnUserCallback {
                override fun onUserLoaded(userResponse: UserResponse, pageNum: Int) {
                    if (!userResponse.userList.isNullOrEmpty()){
                        userList?.addAll(userResponse.userList!!)
                    }
                    currentPage += 1
                    totalPages = userResponse.totalPages ?: 0
                    if (currentPage <= totalPages)
                        fetchUserList(currentPage)
                    else if (currentPage>totalPages)
                        isLoading?.set(false)
                }

                override fun onUserLoadFinished(pageNumber: Int) {
                    if (currentPage > totalPages) {
                        isLoading?.set(false)
                    }
                }
            })
    }


    fun isOnline(): Boolean {
        try {
            val p1 =
                Runtime.getRuntime().exec("ping -c 1 www.google.com")
            val returnVal = p1.waitFor()
            return returnVal == 0
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

}