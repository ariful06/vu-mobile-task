package com.multithread.vumobiletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmedhealth.dghs.corona.dashboard.fragment.FragmentLoader
import com.multithread.vumobiletest.view.UserListFragment
import com.multithread.vumobiletest.view.UserListFragment_


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentLoader.addFragment(
            this,
            UserListFragment_.builder().build(),
            R.id.fragment_holder
        )
    }

    override fun onResume() {
        super.onResume()
    }
}