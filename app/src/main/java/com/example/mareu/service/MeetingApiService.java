package com.example.mareu.service;

import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;

import java.util.List;

/**
 * Meeting API client
 */
public interface MeetingApiService {
    /**
     * Get all my Meeting
     *
     * @return {@link List}
     */
    List<Meeting> getMeeting();

    /**
     * Deletes a meeting
     *
     * @param meeting
     */
    void deleteMeeting(Meeting meeting);

    /**
     * Create a meeting
     *
     * @param meeting
     */
    void createMeeting(Meeting meeting);


    /**
     * Get all my MeetingRooms
     *
     * @return {@link List}
     */
    List<MeetingRoom> getMeetingRooms();

    /**
     * Get all my Employees
     *
     * @return {@link List}
     */
    List<Employee> getEmployees();

}
