package com.example.mareu.service;

import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;
import com.example.mareu.model.Participants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> Dummy_Meetings = Arrays.asList(
            new Meeting(1,"Subject",localisation(), addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"alex@lamzone.com, mark@lamzone.com, justin@lamzone.com"),
            new Meeting(2,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"antoine@lamzone.com, chris@lamzone.com"),
            new Meeting(3,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"robin@lamzone.com, marvin@lamzone.com, antoine@lamzone.com, gaelle@lamzone.com"),
            new Meeting(4,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"etienne@lamzone.com, theo@lamzone.com, agathe@lamzone.com"),
            new Meeting(5,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"marvin@lamzone.com, antoine@lamzone.com, theo@lamzone.com, agathe@lamzone.com"),
            new Meeting(6,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"antoine@lamzone.com, theo@lamzone.com, agathe@lamzone.com"),
            new Meeting(7,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"marvin@lamzone.com, antoine@lamzone.com, luc@lamzone.com, amandine@lamzone.com"),
            new Meeting(8,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"paul@lamzone.com, thibault@lamzone.com, alex@lamzone.com"),
            new Meeting(9,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"viviane@lamzone.com, maxime@lamzone.com, pierre@lamzone.com")
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(Dummy_Meetings); }

    public static List<Meeting> Dummy_Random_Meetings = Arrays.asList(
            new Meeting(10,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"antoine@lamzone.com, chris@lamzone.com"),
            new Meeting(11,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"antoine@lamzone.com, theo@lamzone.com, agathe@lamzone.com"),
            new Meeting(12,"Subject", localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"viviane@lamzone.com, maxime@lamzone.com, pierre@lamzone.com"),
            new Meeting(13,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"marvin@lamzone.com, antoine@lamzone.com, luc@lamzone.com, amandine@lamzone.com"),
            new Meeting(14,"Subject",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),"etienne@lamzone.com, theo@lamzone.com, agathe@lamzone.com")
    );

    public static Date addDays(Date d)  {
        int days = new Random().nextInt(8);
        d.setTime(d.getTime() + days * 1000L * 60L * 60L * 24L);
        return d;
    }

    public static List<MeetingRoom> MEETING_ROOMS = Arrays.asList(
            new MeetingRoom(1,R.drawable.ic_baseline_circle_24, "Sydney", "RDC", 12),
            new MeetingRoom(2,R.drawable.ic_baseline_circle_24, "New York", "RDC", 5),
            new MeetingRoom(3,R.drawable.ic_baseline_circle_24, "London", "1er étage", 2),
            new MeetingRoom(4,R.drawable.ic_baseline_circle_24, "Rio", "1er étage", 20),
            new MeetingRoom(5,R.drawable.ic_baseline_circle_24, "Oslo", "2ème", 6),
            new MeetingRoom(6,R.drawable.ic_baseline_circle_24, "Cape Town", "2ème étage", 12),
            new MeetingRoom(4,R.drawable.ic_baseline_circle_24, "Vancouver", "2ème étage", 6),
            new MeetingRoom(5,R.drawable.ic_baseline_circle_24, "Singapore", "3ème", 6),
            new MeetingRoom(6,R.drawable.ic_baseline_circle_24, "paris", "3ème étage", 12)
            );
    public static MeetingRoom localisation(){
        return MEETING_ROOMS.get(new Random().nextInt(MEETING_ROOMS.size()));
    }

    public static List<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", true),
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", false)
            new Employee("Martin", "Amandine", "Commercial", "Commercial", "alex@lamzone.com", true),
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", false)
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", true),
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", true),
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", false)
            new Employee("Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", true),
    );
    public static Employee participants(){
        return EMPLOYEES.get(new Random().nextInt(EMPLOYEES.size()));
    }

}
