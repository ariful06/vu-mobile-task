package com.cmedhealth.dghs.corona.dashboard.fragment

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.blankj.utilcode.util.FragmentUtils
import com.multithread.vumobiletest.R


class FragmentLoader {

    companion object {
        @JvmStatic
        fun replaceFragment(
            mActivity: Activity? = null,
            fragment: Fragment,
            fragment_holder: Int? = null
        ) {
            if (mActivity == null) return
            FragmentUtils.replace(
                (mActivity as FragmentActivity).supportFragmentManager,
                fragment,
                fragment_holder ?: R.id.fragment_holder,
                true,
                R.anim.enter_from_right,
                R.anim.exit_to_left
            )
        }

        @JvmStatic
        fun replaceFragment(
            mActivity: Activity? = null,
            fragment: Fragment,
            fragment_holder: Int? = null,
            isAddStack: Boolean
        ) {
            if (mActivity == null) return
            FragmentUtils.replace(
                (mActivity as FragmentActivity).supportFragmentManager,
                fragment,
                fragment_holder ?: R.id.fragment_holder,
                isAddStack,
                R.anim.enter_from_right,
                R.anim.exit_to_left
            )
        }

        @JvmStatic
        fun addFragment(mActivity: Activity? = null, fragment: Fragment, fragment_holder: Int) {
            if (mActivity == null) return
            FragmentUtils.add(
                (mActivity as FragmentActivity).supportFragmentManager,
                fragment,
                fragment_holder
            )
        }

    }
}