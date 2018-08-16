package br.com.hay.register

import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.hay.R
import br.com.hay.app.HayApplication
import br.com.hay.base.BaseActivity
import br.com.hay.login.RegisterContract
import br.com.hay.login.RegisterPresenter
import br.com.hay.wrapper.ContextWrapperImpl
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : BaseActivity(), RegisterContract.View, View.OnClickListener {

    private lateinit var mPresenter: RegisterPresenter
    private lateinit var mEtEmail: TextInputEditText
    private lateinit var mEtName: TextInputEditText
    private lateinit var mEtPassword: TextInputEditText
    private lateinit var mBtSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
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

    override fun getName(): String {
        return mEtName?.toString()
    }

    override fun getEmail(): String {
        return mEtEmail?.toString()
    }

    override fun getPassword(): String {
        return mEtPassword?.toString()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.register_bt_send -> mPresenter?.sendClick()
        }
    }

    override fun setPresenter(presenter: RegisterContract.Presenter) {
        mPresenter = presenter as RegisterPresenter
    }

    private fun initComponents() {
        val mContextWrapper = ContextWrapperImpl(getActivityContext())
        setPresenter(RegisterPresenter(
                (application as HayApplication).getRouter(mContextWrapper)))
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
