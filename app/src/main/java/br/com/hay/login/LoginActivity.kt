package br.com.hay.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import br.com.hay.R
import br.com.hay.app.HayApplication
import br.com.hay.base.BaseActivity
import br.com.hay.wrapper.ContextWrapperImpl

import com.google.android.material.textfield.TextInputEditText

class LoginActivity : BaseActivity(), LoginContract.View, View.OnClickListener {

    private lateinit var mPresenter: LoginPresenter
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mEtPassword: TextInputEditText
    private lateinit var mTvForgotPassword: TextView
    private lateinit var mTvRegister: TextView
    private lateinit var mBtSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = presenter as LoginPresenter
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.login_tv_forgot_password -> mPresenter.forgotPasswordClick()
            R.id.login_tv_register        -> mPresenter.registerClick()
            R.id.login_bt_sign_in         -> mPresenter.loginClick()
        }
    }

    override fun getEmail(): String {
        return mEtEmail?.toString()
    }

    override fun getPassword(): String {
        return mEtPassword?.toString()
    }

    private fun initComponents() {
        val mContextWrapper = ContextWrapperImpl(getActivityContext())
        setPresenter(LoginPresenter(
                (application as HayApplication).getRouter(mContextWrapper)))
    }

    private fun initViews() {
        mEtEmail = findViewById(R.id.login_et_email)
        mEtPassword = findViewById(R.id.login_et_password)
        mTvForgotPassword = findViewById(R.id.login_tv_forgot_password)
        mTvRegister = findViewById(R.id.login_tv_register)
        mBtSignIn = findViewById(R.id.login_bt_sign_in)

        //Add Listeners
        mTvForgotPassword.setOnClickListener(this)
        mTvRegister.setOnClickListener(this)
        mBtSignIn.setOnClickListener(this)
    }
}
