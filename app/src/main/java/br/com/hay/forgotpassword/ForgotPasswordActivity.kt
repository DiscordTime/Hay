package br.com.hay.forgotpassword

import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.hay.R
import br.com.hay.base.BaseActivity
import br.com.hay.login.ForgotPasswordContract
import br.com.hay.login.ForgotPasswordPresenter

import com.google.android.material.textfield.TextInputEditText
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.View, View.OnClickListener {

    override fun activityModule() = Kodein.Module("forgotPasswordActivity") {
        import(forgotPasswordActivityModule())
    }

    private val mPresenter by instance<ForgotPasswordPresenter>()
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mBtSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initViews()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.resume(this)
    }

    override fun onPause() {
        super.onPause()
        mPresenter.pause()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.forgot_password_bt_send -> mPresenter?.sendClick()
        }
    }

    override fun getEmail(): String {
        return mEtEmail?.toString()
    }

    private fun initViews() {
        mEtEmail = findViewById(R.id.forgot_password_et_email)
        mBtSend = findViewById(R.id.forgot_password_bt_send)

        //Add Listeners
        mBtSend.setOnClickListener(this)
    }
}
