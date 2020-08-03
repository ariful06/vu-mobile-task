package com.multithread.vumobiletest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.multithread.vumobiletest.databinding.FragmentFullImageBinding
import com.multithread.vumobiletest.fragment.LifeCycleFragment
import com.multithread.vumobiletest.model.dto.User
import com.multithread.vumobiletest.viewmodel.FullImageViewModel
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.FragmentArg


@EFragment
open class FullImageViewFragment : LifeCycleFragment(){

    private var viewModel: FullImageViewModel? = null
    private var binding: FragmentFullImageBinding? = null

    @FragmentArg
    lateinit var user: User
    override fun onVisible() {

    }

    override fun onInvisible() {

    }

    override fun initDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFullImageBinding.inflate(inflater!!, container, false)
        viewModel = ViewModelProviders.of(this).get(FullImageViewModel::class.java)
        binding?.viewModel = viewModel
        viewModel?.start(user)
        return binding?.root
    }

}