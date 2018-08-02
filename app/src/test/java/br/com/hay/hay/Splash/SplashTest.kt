package br.com.hay.hay.Splash

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso
import org.junit.After

@RunWith(AndroidJUnit4::class)
class SplashTest {

    @Rule
    var activityTestRule: ActivityTestRule<SplashActivity> = ActivityTestRule(SplashActivity::class.java)
    private val splashScreenWaitingTime = 1100

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun waitMoreThemThreeSeg() {

        activityTestRule.launchActivity(null)
        val idlingResource = ElapsedTimeIdlingResource(splashScreenWaitingTime)
    }

    @Test
    @Throws(InterruptedException::class)
    fun viewSplashScreenSecondTime_NavigateToListBooksAfter1000ms() {

        activityTestRule.launchActivity(null)
        val idlingResource = ElapsedTimeIdlingResource(splashScreenWaitingTime)
        Espresso.registerIdlingResources(idlingResource)

    }
}