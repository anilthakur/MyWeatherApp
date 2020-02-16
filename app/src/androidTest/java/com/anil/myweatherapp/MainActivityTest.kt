package com.anil.myweatherapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.anil.myweatherapp.persentation.view.MainActivity
import junit.framework.Assert.assertEquals
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Anil Kumar on 2020-02-15
 */
@LargeTest
@RunWith(
    AndroidJUnit4ClassRunner::class
)
class MainActivityTest {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun container_IsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.mainContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.address))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.status))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.temp))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(ViewMatchers.withId(R.id.temp_min))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.temp_max))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().getTargetContext()
        assertEquals("com.anil.myweatherapp", appContext.getPackageName())
    }

    @Test
    fun testRecyclerVisible() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun recyclerViewScrollToPositionTest() {
        val recyclerView = activityRule.getActivity().findViewById<RecyclerView>(R.id.recyclerView)
        val itemCount = recyclerView.getAdapter()!!.getItemCount()
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityRule.activity.window.decorView)))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(itemCount - 1))


    }


}