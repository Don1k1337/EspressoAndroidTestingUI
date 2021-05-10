package com.example.espressouitesting;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.rule.ActivityTestRule.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String mName = "Tony";

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testUserInputScenario()
    {
        // input some text in the edit text
        Espresso.onView(withId(R.id.etTextToChange)).perform(typeText(mName));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.btnChange)).perform(click());
        // checking the text in the textview
        Espresso.onView(withId(R.id.tvChangedText)).check(matches(withText(mName)));
    }



    @After
    public void tearDown() throws Exception {

    }

}