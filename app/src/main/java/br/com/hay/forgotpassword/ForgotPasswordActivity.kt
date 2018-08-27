package br.com.hay.forgotpassword

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.hay.R
import br.com.hay.base.BaseActivity

import com.google.android.material.textfield.TextInputEditText
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.View, View.OnClickListener {

    override fun activityModule() = Kodein.Module("forgotPasswordActivity") {
        import(forgotPasswordActivityModule(app()))
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

    override fun showError(message: String) {
        AlertDialog.Builder(this).setMessage(message).setCancelable(false).show()
    }

    private fun initViews() {
        mEtEmail = findViewById(R.id.forgot_password_et_email)
        mBtSend = findViewById(R.id.forgot_password_bt_send)

        //Add Listeners
        mBtSend.setOnClickListener(this)
    }
}
