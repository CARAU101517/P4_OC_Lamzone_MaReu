package com.example.mareu;

import com.example.mareu.di.DI;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;
import com.example.mareu.service.DummyMeetingGenerator;
import com.example.mareu.service.MeetingApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class MeetingServiceUnitTest {

private MeetingApiService service;

@Before
public void setup() {
        service = DI.getNewInstanceApiService();
        }

@Test
public void getMeetingsWithSuccess(){
        Meeting meeting1ToCreate = new Meeting((int) service.getMeeting().size(),"Mon meeting Test 1", service.getMeetingRooms().get(3),
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
        service.createMeeting(meeting1ToCreate);
        Meeting meeting2ToCreate = new Meeting((int) service.getMeeting().size(),"Mon meeting Test 2", service.getMeetingRooms().get(6),
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
        service.createMeeting(meeting2ToCreate);
        List<Meeting> meetings = service.getMeeting();
        assertEquals(2, meetings.size());
        }

@Test
public void deleteMeetingWithSuccess() {
        Meeting meetingToCreate = new Meeting((int) service.getMeeting().size(),"Mon meeting Test", service.getMeetingRooms().get(5),
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
        service.createMeeting(meetingToCreate);
        Meeting meetingToDelete = service.getMeeting().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));
        }

@Test
public void createMeetingWithSuccess() {
        Meeting meetingToCreate = new Meeting((int) service.getMeeting().size(),"Mon meeting Test", service.getMeetingRooms().get(8),
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
        service.createMeeting(meetingToCreate);
        assertTrue(service.getMeeting().contains(meetingToCreate));
        List<Meeting> meetings = service.getMeeting();
        assertEquals(1, meetings.size());
        }

}