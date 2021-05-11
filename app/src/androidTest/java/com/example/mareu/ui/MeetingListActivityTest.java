package com.example.mareu.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.mareu.R;
import com.example.mareu.ui.utils.DeleteViewAction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.ui.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MeetingListActivityTest {

    private static int ITEM_COUNT = 0;
    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityTestRule = new ActivityTestRule<>(MeetingListActivity.class);


    @Test
    public void myMeetingList_shouldBeNotNull() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .check(withItemCount((ITEM_COUNT)));
    }


    @Test
    public void createMeeting () {
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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        materialTextView2.perform(click());

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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatMultiAutoCompleteTextView = onView(
                allOf(withId(R.id.participants),
                        childAtPosition(
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatMultiAutoCompleteTextView.perform(replaceText("luc@lamzone.com, "), closeSoftKeyboard());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.add_meeting_subject),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Test 2"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.save_meeting), withText("Enregistrer"),
                        childAtPosition(
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction recyclerView3 = onView(allOf(withId(R.id.recycler_view), isDisplayingAtLeast(60)));
        recyclerView3.check(withItemCount(ITEM_COUNT+1));
        ITEM_COUNT++;
    }

    @Test
    public void myMeetingList_deleteAction_shouldRemoveItem() {
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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        materialTextView2.perform(click());

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
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatSpinner.perform(click());

        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatMultiAutoCompleteTextView = onView(
                allOf(withId(R.id.participants),
                        childAtPosition(
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatMultiAutoCompleteTextView.perform(replaceText("luc@lamzone.com, "), closeSoftKeyboard());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.add_meeting_subject),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Test 2"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.save_meeting), withText("Enregistrer"),
                        childAtPosition(
                                allOf(withId(R.id.activity_add_meeting),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        materialButton5.perform(click());

        onView(allOf(withId(R.id.recycler_view), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        ITEM_COUNT++;
        onView(allOf(withId(R.id.recycler_view), isDisplayed())).check(withItemCount(ITEM_COUNT-1));
        ITEM_COUNT--;
    }

    @Test
    public void addMeetingDateBeginExist() {
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

        ViewInteraction textView = onView(
                allOf(withId(R.id.add_start_date_and_time_meeting),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
    }

    @Test
    public void addMeetingDateEndExist() {
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

     ViewInteraction textView2 = onView(
             allOf(withId(R.id.add_end_date_and_time_meeting),
                     isDisplayed()));
     textView2.check(matches(isDisplayed()));

    }

    @Test
    public void addMeetingRoomExist() {
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


    ViewInteraction spinner = onView(
            allOf(withId(R.id.spinner_meeting_room),
                    withParent(allOf(withId(R.id.activity_add_meeting),
                            withParent(withId(android.R.id.content)))),
                    isDisplayed()));
    spinner.check(matches(isDisplayed()));

    }

   @Test
    public void addParticipantsExist() {
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


       ViewInteraction multiAutoCompleteTextView = onView(
               allOf(withId(R.id.participants),
                       isDisplayed()));
       multiAutoCompleteTextView.check(matches(isDisplayed()));

    }

    @Test
    public void addTitleExist() {
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


        ViewInteraction editText = onView(
                allOf(withId(R.id.add_meeting_subject),
                        isDisplayed()));
        editText.check(matches(isDisplayed()));

    }

    @Test
    public void addSaveButtonExist() {
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

        ViewInteraction button = onView(
                allOf(withId(R.id.save_meeting), withText("Enregistrer"),
                        withParent(allOf(withId(R.id.activity_add_meeting),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
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
