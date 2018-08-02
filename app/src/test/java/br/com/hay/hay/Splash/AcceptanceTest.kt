package br.com.hay.hay.Splash

import android.app.Activity
import android.provider.CalendarContract
import org.junit.Rule
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class AcceptanceTest<T : Activity>(clazz: Class<T>) {

    @Rule
    @JvmField
    val testRule: ActivityTestRule<T> = IntentsTestRule(clazz)

    val checkThat: Matchers = Matchers()
    val events: CalendarContract.Events = CalendarContract.Events()
}