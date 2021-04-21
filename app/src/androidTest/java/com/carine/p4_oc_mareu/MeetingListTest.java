package com.carine.p4_oc_mareu;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.provider.ContactsContract;
import android.provider.ContactsContract.DeletedContacts;
import android.widget.DatePicker;
import androidx.test.espresso.ViewInteraction;
import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;
import com.example.mareu.service.DummyMeetingApiService;
import com.example.mareu.service.DummyMeetingGenerator;
import com.example.mareu.service.MeetingApiService;
import com.example.mareu.ui.MeetingListActivity;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)

public class MeetingListTest {

    private MeetingListActivity mMeetingsListActivity;
    private static int ITEMS_COUNT = 3;

    private MeetingApiService mApiService = new DummyMeetingApiService();
    private List<Meeting> mMeetings = mApiService.getMeeting();
    private List<MeetingRoom> mRooms = DummyMeetingGenerator.generateMeetingRooms();
    private List<Employee> employees = new ArrayList<>();
    /**
     // rules
    @Rule
    public ActivityTestRule<MeetingListActivity> mActivityRule =
            new ActivityTestRule(MeetingListActivity.class);

    @Before
    public void setUp()
    {
        mMeetingsListActivity = mActivityRule.getActivity();
        assertThat(mMeetingsListActivity, notNullValue());

        mApiService.getMeeting().clear();

        Meeting meetingTest1 = new Meeting(1, "Test1", DummyMeetingGenerator.generateMeetingRooms().get(2),
                DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()), DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()),
                new ArrayList<>(DummyMeetingGenerator.generateFakeParticipants()));
        Meeting meetingTest2 = new Meeting(1, "Test2", DummyMeetingGenerator.generateMeetingRooms().get(6),
                DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()), DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()),
                new ArrayList<>(DummyMeetingGenerator.generateFakeParticipants()));
        Meeting meetingTest3 = new Meeting(1, "Test3", DummyMeetingGenerator.generateMeetingRooms().get(8),
            DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()), DummyMeetingGenerator.addDays(Calendar.getInstance().getTime()),
            new ArrayList<>(DummyMeetingGenerator.generateFakeParticipants()));

        mApiService.createMeeting(meetingTest1);
        mApiService.createMeeting(meetingTest2);
        mApiService.createMeeting(meetingTest3);
    }

    @Test
    public void myMeetingsList_shouldNotBeEmpty()
    {
        //On the first page, we have the 3 Reu add in the SetUp
        onView(ViewMatchers.withId(R.id.activity_meeting_list)).check(matches(hasMinimumChildCount(ITEMS_COUNT)));
    }

    @Test
    public void myAddMeeting_clickAction_shouldDisplayActivity()
    {
        // When : we click on the fab button
        onView(ViewMatchers.withId(R.id.add_meeting)).perform(click());

        // Then : Go to the AddMeetingActiviy
        onView(ViewMatchers.withId(R.id.activity_add_meeting)).check(matches(isDisplayed()));

    }


    @Test
    public void myMeetingsList_deleteAction_shouldRemoveItem()
    {
        // Given : We check that we have 3 Meetings
        onView(ViewMatchers.withId(R.id.activity_meeting_list)).check(matches(hasMinimumChildCount(ITEMS_COUNT)));

        // When : We perform a click on Meeting's position 1 delete button
        onView(withId(R.id.item_list_delete_button))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeletedContacts()));
        onView(ViewMatchers.withId(R.id.item_list_delete_button)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));

        // Then : The Meetings List has 2 items
        onView(ViewMatchers.withId(R.id.activity_meeting_list)).check(matches(hasMinimumChildCount(ITEMS_COUNT-1)));

    }

    @Test
    public void myMeetingsList_clickToolbarAction_shouldDisplayFilterDate()
    {
        // Given : We check that we have 3 meetings
        onView(ViewMatchers.withId(R.id.activity_meeting_list)).check(matches(hasMinimumChildCount(ITEMS_COUNT)));

        // When : We click on the toolbar and put a Date
        onView(withId(R.menu.filter_menu)).perform(click());
        onView(withId(R.id.date_filter)).perform(click());
        onView(isAssignableFrom(DatePicker.class)).perform(PickerActions.setDate(2021, 4, 21));
        onView(withId(R.id.ok)).perform(click());

        // Then : We have the meetings with this date
        onView(ViewMatchers.withId(R.id.activity_meeting_list)).check(matches(hasMinimumChildCount(2)));

    }

   */


}


