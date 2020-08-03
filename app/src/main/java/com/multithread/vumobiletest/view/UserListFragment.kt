package com.multithread.vumobiletest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmedhealth.dghs.corona.dashboard.fragment.FragmentLoader
import com.multithread.vumobiletest.R
import com.multithread.vumobiletest.adapter.UserListAdapter
import com.multithread.vumobiletest.databinding.FragmentUserListBinding
import com.multithread.vumobiletest.fragment.LifeCycleFragment
import com.multithread.vumobiletest.model.dto.User
import com.multithread.vumobiletest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment

@EFragment
open class UserListFragment : LifeCycleFragment(){

    private var viewModel: UserViewModel? = null
    private var binding: FragmentUserListBinding? = null

    private var mLayoutManager : LinearLayoutManager ? = null
    private var adapter : UserListAdapter? = null

    @AfterViews
    open fun init(){

        initRecyclerView(rvUserList)
        setupRecyclerAdapter(rvUserList)
    }

    override fun onVisible() {

    }

    override fun onInvisible() {

    }

    override fun initDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater!!, container, false)
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        binding?.viewModel = viewModel
        viewModel?.start()
        subscribeToObserver()
        return binding?.root
    }

   private fun subscribeToObserver(){
        viewModel?.userItemClickSingleLiveEvent?.observe(this, Observer {user-> redirectToFullImagePage(user) })
    }

    private fun redirectToFullImagePage(user: User?) {
        FragmentLoader.replaceFragment(mActivity!!,FullImageViewFragment_.builder().user(user).build(),
            R.id.fragment_holder,isAddStack = true)
    }

    private fun initRecyclerView(mRecyclerView: RecyclerView) {
        mLayoutManager = LinearLayoutManager(mRecyclerView.context, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.layoutManager = GridLayoutManager(mActivity!!, 2)
    }

    private fun setupRecyclerAdapter(mRecyclerView: RecyclerView) {
            adapter = UserListAdapter(ArrayList(0), viewModel!!)
            mRecyclerView.adapter = adapter
            adapter?.notifyDataSetChanged()
    }

}