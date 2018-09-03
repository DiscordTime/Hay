package br.com.hay.feelings

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

import br.com.hay.R
import br.com.hay.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity() {

    private lateinit var mNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mNavigation = findViewById(R.id.feeling_navigation)
        val navController = Navigation.findNavController(this, R.id.fragment_main)
        NavigationUI.setupWithNavController(mNavigation, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment_main).navigateUp()
    }
}
