package com.example.padcx_movieapp_assignment.uitests

import android.content.Intent
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.activities.MainActivity
import com.example.padcx_movieapp_assignment.views.viewHolders.BestPopularMovieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoToDetailActivityTest {
    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }



    @Test
    fun tapOnPopularItem_navigateToDetail(){
        onView(withId(R.id.rvBestPopularMovie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<BestPopularMovieViewHolder>(1,ViewActions.click()))

        onView(withId(R.id.iv_back))
            .check(matches(isDisplayed()))
    }




}
