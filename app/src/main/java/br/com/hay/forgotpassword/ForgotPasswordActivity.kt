package br.com.hay.forgotpassword

import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.hay.R
import br.com.hay.app.HayApplication
import br.com.hay.base.BaseActivity
import br.com.hay.login.ForgotPasswordContract
import br.com.hay.login.ForgotPasswordPresenter
import br.com.hay.wrapper.ContextWrapperImpl

import com.google.android.material.textfield.TextInputEditText

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.View, View.OnClickListener {

    private lateinit var mPresenter: ForgotPasswordPresenter
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mBtSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initComponents()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.start(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.finish()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.forgot_password_bt_send -> mPresenter.sendClick()
        }
    }

    override fun getEmail(): String {
        return mEtEmail?.toString()
    }

    override fun setPresenter(presenter: ForgotPasswordContract.Presenter) {
        mPresenter = presenter as ForgotPasswordPresenter
    }

    private fun initComponents() {
        val mContextWrapper = ContextWrapperImpl(getActivityContext())
        setPresenter(ForgotPasswordPresenter(
                (application as HayApplication).getRouter(mContextWrapper)))
    }

    private fun initViews() {
        mEtEmail = findViewById(R.id.forgot_password_et_email)
        mBtSend = findViewById(R.id.forgot_password_bt_send)

        //Add Listeners
        mBtSend.setOnClickListener(this)
    }
}
