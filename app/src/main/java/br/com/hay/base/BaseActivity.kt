package br.com.hay.base

import androidx.appcompat.app.AppCompatActivity
import br.com.hay.wrapper.ActivityWrapper

open class BaseActivity : AppCompatActivity(), ActivityWrapper {

    override fun getActivityContext(): ActivityWrapper {
        return this
    }
}