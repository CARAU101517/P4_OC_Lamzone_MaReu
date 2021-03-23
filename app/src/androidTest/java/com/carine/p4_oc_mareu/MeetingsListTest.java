package com.carine.p4_oc_mareu;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.mareu.R;
import com.example.mareu.ui.MeetingListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingsListTest {

    /*private static int ITEMS_COUNT = 9;
    private MeetingListActivity mActivity;

    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityRule = new ActivityTestRule(MeetingListActivity.class);

    @Rule
    public IntentsTestRule<MeetingListActivity> mActivityRule2 = new IntentsTestRule<>(MeetingListActivity.class);


    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }


    *//**
     * We ensure that our recyclerview is displaying at least on item
     *//*
    @Test
    public void myMeetingsList_shouldNotBeEmpty() {
        onView(allOf(withId(R.id.activity_meeting_list)))
                .check(matches(hasMinimumChildCount(1)));
    }

    *//**
     * When we delete an item, the item is no more shown
     *//*
    @Test
    public void myMeetingsList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.activity_meeting_list)
                .check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.activity_meeting_list)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, new DeleteViewAction()));
        // Then : the number of element is 8
        onView(allOf(withId(R.id.activity_meeting_list))).check(withItemCount(ITEMS_COUNT-1));
    }

    *//**
     * When we add a meeting, the new meeting is showing in the meeting list
     *//*
    @Test
    public void myMeetingsList_createAction_shouldAddItem() {
        onView(withId(R.id.add_meeting)).perform(click());
        onView(withId(R.id.activity_meeting_list)).check(new RecyclerViewUtils.ItemCount(ITEMS_COUNT+1));
    }*/

}