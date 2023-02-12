package com.example.affirmations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert

@RunWith(AndroidJUnit4::class)

class AffirmationsListTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)





    @Test
    fun scroll_to_item() {



        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(9)
        )
/*Note: Notice that a hard coded value of 9 was passed for the position, this only works because the size of the list in this app is static. If the app had a dynamic list size, using a hardcoded value would not be a good practice
 for the good practise they replaced the code above with the code bellow(case where list is not static)
 but it didn't work for me

        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollTo<RecyclerView.ViewHolder>(
                    withText(R.string.affirmation10)
                )
        )*/

        onView(withText(R.string.affirmation10))
            .check(matches(isDisplayed()))
    }

}