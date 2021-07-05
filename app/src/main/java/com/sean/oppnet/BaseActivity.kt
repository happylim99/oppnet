package com.sean.oppnet

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected val TAG = "MyDebug"
    protected lateinit var binding: VB

}