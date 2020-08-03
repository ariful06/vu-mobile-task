package com.multithread.vumobiletest.util

import org.androidannotations.annotations.sharedpreferences.*


@SharedPref(SharedPref.Scope.UNIQUE)
open interface AppPreference {
    @DefaultInt(1)
    fun currentPage(): Int
}
