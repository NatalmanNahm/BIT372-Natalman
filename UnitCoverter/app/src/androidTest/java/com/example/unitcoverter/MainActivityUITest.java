package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    @Test
    public void can_select_option_in_spinner(){
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.conversion_label)).check(matches(withText("Mile to Kilometer")));

    }

    @Test
    public void can_convert_to_celsius() {
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());
        onView(withId(R.id.fahrenheit_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.celcius_text)).check(matches(withText("45.00 ºF is 7.22 ºC")));
    }

    @Test
    public void should_not_enter_empty_fah() {
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.celcius_text)).check(matches(withText("ºF is ºC")));
    }
    @Test
    public void can_convert_to_km(){
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(2).perform(click());
        onView(withId(R.id.fahrenheit_input)).perform(typeText("75"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.celcius_text)).check(matches(withText("75.00 miles is 120.70 km")));
    }



//    @Test
//    public void can_convert_to_kg(){
//        onView(withId(R.id.lbs_editText)).perform(typeText("50"));
//        onView(withId(R.id.convert_to_kg)).perform(click());
//        onView(withId(R.id.kg_convert)).check(matches(withText("22.68 Kg")));
//    }
//
//    @Test
//    public void cannot_convert_0lbs(){
//        onView(withId(R.id.lbs_editText)).perform(typeText("0"));
//        onView(withId(R.id.convert_to_kg)).perform(click());
//        onView(withId(R.id.kg_convert)).check(matches(withText("Cannot convert 0 lbs")));
//    }
}