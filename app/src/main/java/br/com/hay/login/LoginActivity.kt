package br.com.hay.login

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import br.com.hay.R
import br.com.hay.base.BaseActivity

import com.google.android.material.textfield.TextInputEditText
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class LoginActivity : BaseActivity(), LoginContract.View, View.OnClickListener {

    override fun activityModule() = Kodein.Module("loginActivity") {
        import(loginActivityModule(app()))
    }

    private val mPresenter by instance<LoginPresenter>()
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mEtPassword: TextInputEditText
    private lateinit var mTvForgotPassword: TextView
    private lateinit var mTvRegister: TextView
    private lateinit var mBtSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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
            R.id.login_tv_forgot_password -> mPresenter.forgotPasswordClick()
            R.id.login_tv_register        -> mPresenter.registerClick()
            R.id.login_bt_sign_in         -> mPresenter.loginClick()
        }
    }

    override fun getEmail(): String {
        return mEtEmail.text.toString()
    }

    override fun getPassword(): String {
        return mEtPassword.text.toString()
    }

    override fun showError(message: String) {
        AlertDialog.Builder(this).setMessage(message).setCancelable(false).show()
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
