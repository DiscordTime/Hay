package br.com.hay.register

import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.hay.R
import br.com.hay.base.BaseActivity
import com.google.android.material.textfield.TextInputEditText
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class RegisterActivity : BaseActivity(), RegisterContract.View, View.OnClickListener {

    override fun activityModule() = Kodein.Module("registerActivity") {
        import(registerActivityModule())
    }

    private val mPresenter by instance<RegisterPresenter>()
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mEtName: TextInputEditText
    private lateinit var mEtPassword: TextInputEditText
    private lateinit var mBtSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
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

    override fun getName(): String {
        return mEtName.toString()
    }

    override fun getEmail(): String {
        return mEtEmail.toString()
    }

    override fun getPassword(): String {
        return mEtPassword.toString()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.register_bt_send -> mPresenter.sendClick()
        }
    }

    private fun initViews() {
        mEtEmail = findViewById(R.id.register_et_email)
        mEtName = findViewById(R.id.register_et_name)
        mEtPassword = findViewById(R.id.register_et_password)
        mBtSend = findViewById(R.id.register_bt_send)

        //Add Listeners
        mBtSend.setOnClickListener(this)
    }
}
