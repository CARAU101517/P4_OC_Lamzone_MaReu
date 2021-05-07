package com.example.mareu;

import com.example.mareu.di.DI;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;
import com.example.mareu.service.DummyMeetingGenerator;
import com.example.mareu.service.MeetingApiService;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.mareu.service.DummyMeetingGenerator.generateEmployees;
import static org.junit.Assert.*;

public class MeetingServiceUnitTest {

private MeetingApiService service;

@Before
public void setup() {
        service = DI.getNewInstanceApiService();
        }


        @Test
        public void generateListMeetingWithSuccess() {
                List<Meeting> lMeetings =  DummyMeetingGenerator.generateMeetings();
                int listSize = lMeetings.size();
                assertEquals(0, listSize);
        }

        @Test
        public void createMeetingWithSuccess() {
                Meeting meetingToCreate = new Meeting(1, "My meeting Test", DummyMeetingGenerator.generateMeetingRooms().get(1),
                        Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
                service.createMeeting(meetingToCreate);
                assertTrue(service.getMeeting().contains(meetingToCreate));
        }

        @Test
        public void getMeetingsWithSuccess(){
                Meeting meeting1ToCreate = new Meeting((int) service.getMeeting().size(),"meeting Test 1", service.getMeetingRooms().get(3),
                        Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
                service.createMeeting(meeting1ToCreate);
                Meeting meeting2ToCreate = new Meeting((int) service.getMeeting().size(),"meeting Test 2", service.getMeetingRooms().get(6),
                        Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
                service.createMeeting(meeting2ToCreate);
                List<Meeting> meetings = service.getMeeting();
                assertEquals(2, meetings.size());
        }

        @Test
        public void deleteMeetingWithSuccess() {
                Meeting meetingToCreate = new Meeting((int) service.getMeeting().size(),"meeting Test", service.getMeetingRooms().get(5),
                        Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), (ArrayList<Employee>) service.getEmployees());
                service.createMeeting(meetingToCreate);
                Meeting meetingToDelete = service.getMeeting().get(0);
                service.deleteMeeting(meetingToDelete);
                assertFalse(service.getMeeting().contains(meetingToDelete));
        }


        @Test
        public void createMeetingRoomWithSuccess() {
                ArrayList<MeetingRoom> mMeetingRoom = (ArrayList<MeetingRoom>) DummyMeetingGenerator.generateMeetingRooms();
                MeetingRoom meetingRoom = new MeetingRoom(11,R.color.LondonRoom, "Tokyo", "1er étage", 40);
                mMeetingRoom.add(meetingRoom);
                assertTrue(mMeetingRoom.contains(meetingRoom));
        }

        @Test
        public void getMeetingsFilterRoom() {
                ArrayList<String> rooms = new ArrayList<>();
                rooms.add("Oslo");
                rooms.add("Rio");
                //rooms to test
                List<Meeting> meetings = Dummy_Meetings;
                List<Meeting> expectedMeetings = service.getMeetingsFromRoomFilter(rooms,meetings);
                assertEquals(2, expectedMeetings.size());
        }

        @Test
        public void getMeetingsFromDateFilter() {
                List<Meeting> meetings = Dummy_Meetings;
                List<Meeting> expectedMeetings = service.getMeetingsFromDateFilter(Calendar.getInstance().getTime(),meetings);
                assertEquals(6, expectedMeetings.size());
        }

        public static List<Meeting> Dummy_Meetings = Arrays.asList(
                new Meeting(1,"Subject A",DummyMeetingGenerator.generateMeetingRooms().get(6),addDays(Calendar.getInstance().getTime(), 1),addDays(Calendar.getInstance().getTime(), 2),new ArrayList<Employee>(generateEmployees())),
                new Meeting(2,"Subject B",DummyMeetingGenerator.generateMeetingRooms().get(2),addDays(Calendar.getInstance().getTime(), 1),addDays(Calendar.getInstance().getTime(), 3),new ArrayList<Employee>(generateEmployees())),
                new Meeting(3,"Subject C",DummyMeetingGenerator.generateMeetingRooms().get(5),addDays(Calendar.getInstance().getTime(), 0),addDays(Calendar.getInstance().getTime(), 1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(4,"Subject D",DummyMeetingGenerator.generateMeetingRooms().get(7),addDays(Calendar.getInstance().getTime(),0),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(5,"Subject E",DummyMeetingGenerator.generateMeetingRooms().get(3),addDays(Calendar.getInstance().getTime(),0),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(6,"Subject F",DummyMeetingGenerator.generateMeetingRooms().get(9),addDays(Calendar.getInstance().getTime(), 0),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(7,"Subject I",DummyMeetingGenerator.generateMeetingRooms().get(1),addDays(Calendar.getInstance().getTime(),0),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(8,"Subject J",DummyMeetingGenerator.generateMeetingRooms().get(4),addDays(Calendar.getInstance().getTime(),0),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())),
                new Meeting(9,"Subject K",DummyMeetingGenerator.generateMeetingRooms().get(0),addDays(Calendar.getInstance().getTime(),2),addDays(Calendar.getInstance().getTime(),1),new ArrayList<Employee>(generateEmployees())));


        public static Date addDays(Date d, int dayIncr) {
                int days = dayIncr;
                d.setTime(d.getTime() + days * 1000L * 60L * 60L * 24L);
                return d;
        }
}