package br.com.hay.hay.Splash

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity

import br.com.hay.hay.Login.LoginActivity

class SplashRouter : SplashContract.Router, AppCompatActivity() {

    override fun openLoginActivity() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}