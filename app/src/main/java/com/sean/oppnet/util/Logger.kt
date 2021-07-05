package com.sean.oppnet.util

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.sean.oppnet.util.Constant.DEBUG
import com.sean.oppnet.util.Constant.TAG

var isUnitTest = false

fun printLogD(className: String?, message: String ) {
    if (DEBUG && !isUnitTest) {
        Log.d(TAG, "$className: $message")
    }
    else if(DEBUG && isUnitTest){
        println("$className: $message")
    }
}

/*
    Priorities: Log.DEBUG, Log. etc....
 */
fun cLog(msg: String?){
    msg?.let {
        if(!DEBUG){
            FirebaseCrashlytics.getInstance().log(it)
        }
    }

}