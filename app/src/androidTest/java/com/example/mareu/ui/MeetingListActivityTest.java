package com.example.mareu.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MeetingListActivityTest {

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule = new ActivityTestRule<>(MeetingListActivity.class);

    @Test
    public void meetingListActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(R.id.activity_meeting_list),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        recyclerView.check(matches(hasMinimumChildCount(0)));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.add_meeting), withContentDescription("Add meeting button"),
                        childAtPosition(
                                allOf(withId(R.id.activity_meeting_list),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.add_start_date_and_time_meeting),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                0)));
        materialTextView.perform(scrollTo(), click());

        ViewInteraction materialButton = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton.perform(scrollTo(), click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton2.perform(scrollTo(), click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(R.id.add_end_date_and_time_meeting),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                1)));
        materialTextView2.perform(scrollTo(), click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner_meeting_room),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        2),
                                2)));
        appCompatSpinner.perform(scrollTo(), click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(2);
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatMultiAutoCompleteTextView = onView(
                allOf(withId(R.id.participants),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0)));
        appCompatMultiAutoCompleteTextView.perform(scrollTo(), click());

        ViewInteraction appCompatMultiAutoCompleteTextView2 = onView(
                allOf(withId(R.id.participants),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0)));
        appCompatMultiAutoCompleteTextView2.perform(scrollTo(), replaceText("l"), closeSoftKeyboard());

        ViewInteraction appCompatMultiAutoCompleteTextView3 = onView(
                allOf(withId(R.id.participants), withText("l"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0)));
        appCompatMultiAutoCompleteTextView3.perform(scrollTo(), click());

        ViewInteraction appCompatMultiAutoCompleteTextView4 = onView(
                allOf(withId(R.id.participants), withText("l"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0)));
        appCompatMultiAutoCompleteTextView4.perform(scrollTo(), click());

        ViewInteraction appCompatMultiAutoCompleteTextView5 = onView(
                allOf(withId(R.id.participants), withText("l"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0)));
        appCompatMultiAutoCompleteTextView5.perform(scrollTo(), replaceText("l"));

        ViewInteraction appCompatMultiAutoCompleteTextView6 = onView(
                allOf(withId(R.id.participants), withText("l"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout2),
                                        childAtPosition(
                                                withId(R.id.scrollView),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatMultiAutoCompleteTextView6.perform(closeSoftKeyboard());

        DataInteraction materialTextView3 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        materialTextView3.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.add_meeting_subject),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.meeting_subjectLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.save_meeting), withText("Save"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout3),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                4)),
                                1)));
        materialButton5.perform(scrollTo(), click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler_view),
                        withParent(allOf(withId(R.id.activity_meeting_list),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        recyclerView2.check(matches(hasChildCount(1)));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
