package br.com.hay.login

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.hay.ActivityWrapper
import br.com.hay.ContextWrapper
import br.com.hay.R

class LoginActivity : AppCompatActivity(), ActivityWrapper {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
    }

    override fun getActivityContext(): Activity {
        return this
    }
}
