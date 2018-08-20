package br.com.hay.splash

import android.content.res.Resources

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import br.com.hay.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before



@LargeTest
@RunWith(AndroidJUnit4::class)
class SplashTest () {


    @Rule @JvmField val mActivityRule =
            ActivityTestRule<SplashActivity>(SplashActivity::class.java)


    lateinit var resources : Resources

    @Before
    fun init() {
        resources = mActivityRule.getActivity().getResources()
    }


    @Test
    fun imgLoaderIsVisible(){
        onView(withId(R.id.iv_splash_loader)).check(matches(isDisplayed()))
    }

    @Test
    fun textLoaderIsVisible(){
        onView(withId(R.id.tv_splash_loader)).check(matches(isDisplayed()))
    }

    @Test
    fun textLoaderRight(){
        onView(withId(R.id.tv_splash_loader)).check(matches(withText(R.string.splash_loader_text)))
    }

}