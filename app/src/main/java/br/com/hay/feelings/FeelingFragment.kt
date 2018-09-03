package br.com.hay.feelings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import br.com.hay.R

class FeelingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feeling, container, false)
    }

    companion object {

        val TAG = "FeelingFragment"

        @JvmStatic
        fun newInstance() =
                FeelingFragment().apply { arguments = Bundle().apply {} }
    }
}