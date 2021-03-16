package com.example.mareu.service;

import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

        private List<Meeting> mMeetings = DummyMeetingGenerator.generateMeetings();
        private List<MeetingRoom> mMeetingRooms = DummyMeetingGenerator.generateMeetingRooms();
        private List<Employee> mEmployees = DummyMeetingGenerator.generateEmployees();

        @Override
        public List<Meeting> getMeeting() {
            return mMeetings;
        }

        @Override
        public void deleteMeeting(Meeting meeting) {
            mMeetings.remove(meeting);
        }

        @Override
        public void generateRandomMeeting() {
            mMeetings.add(Meeting.random());
        }

        @Override
        public void createMeeting(Meeting meeting) {
            mMeetings.add(meeting);
        }

        @Override
        public List<MeetingRoom> getMeetingRooms() {
        return mMeetingRooms;
    }

        @Override
        public List<Employee> getEmployees() {
        return mEmployees;
    }

}
