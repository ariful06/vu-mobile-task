package com.multithread.vumobiletest.fragment


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.multithread.vumobiletest.base.BaseFragment

abstract class LifeCycleFragment : BaseFragment() {
    var mActivity: Activity? = null

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = context as Activity
        return initDataBinding(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as Activity
    }

    protected abstract fun onVisible()
    protected abstract fun onInvisible()
    protected abstract fun initDataBinding(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
}