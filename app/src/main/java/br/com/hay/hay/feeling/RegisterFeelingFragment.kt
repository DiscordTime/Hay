package br.com.hay.hay.feeling

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import br.com.hay.hay.R

class RegisterFeelingFragment : Fragment(), RegisterFeelingContract.View {

    private lateinit var mPresenter : RegisterFeelingContract.Presenter
    private lateinit var mNextButton : Button
    private lateinit var mSubTitleTextView: TextView
    private lateinit var mFeelingList : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_register_feeling_layout, container, false)

        mNextButton = view.findViewById(R.id.button_next)
        mSubTitleTextView = view.findViewById(R.id.text_sub_title)
        mFeelingList = view.findViewById(R.id.list_feelings)

        mNextButton.setOnClickListener {
            mPresenter.onClickNextButton()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        mPresenter.start()
    }

    override fun setPresenter(presenter: RegisterFeelingContract.Presenter) {
        mPresenter = presenter
    }

    override fun showSubTitle(subTitle: String) {
        mSubTitleTextView.text = subTitle
    }

    override fun showFeelings(feelings: List<Feeling>) {

    }

}
