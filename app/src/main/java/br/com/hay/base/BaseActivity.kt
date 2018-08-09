package br.com.hay.base

import android.support.v7.app.AppCompatActivity
import br.com.hay.wrapper.ActivityWrapper

open class BaseActivity : AppCompatActivity(), ActivityWrapper {

    override fun getActivityContext(): ActivityWrapper {
        return this
    }
}