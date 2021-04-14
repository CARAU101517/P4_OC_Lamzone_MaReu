package com.example.mareu.service;


import androidx.core.content.ContextCompat;

import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public abstract class DummyMeetingGenerator {

    public static List<MeetingRoom> MEETING_ROOMS = Arrays.asList(
            new MeetingRoom(1,R.color.SydneyRoom, "Sydney", "RDC", 12),
            new MeetingRoom(2,R.color.NewYorkRoom, "New York", "RDC", 5),
            new MeetingRoom(3,R.color.LondonRoom, "London", "1er étage", 4),
            new MeetingRoom(4,R.color.RioRoom, "Rio", "1er étage", 20),
            new MeetingRoom(5,R.color.OsloRoom, "Oslo", "2ème", 6),
            new MeetingRoom(6,R.color.CapeTownRoom, "Cape Town", "2ème étage", 12),
            new MeetingRoom(7,R.color.VancouverRoom, "Vancouver", "2ème étage", 6),
            new MeetingRoom(8,R.color.SingaporeRoom, "Singapore", "3ème", 6),
            new MeetingRoom(9,R.color.ParisRoom, "Paris", "3ème étage", 12),
            new MeetingRoom(10,R.color.SanFranciscoRoom, "San Francisco", "3ème étage", 4)
    );

    public static List<MeetingRoom> generateMeetingRooms() { return new ArrayList<>(MEETING_ROOMS); }

    public static List<Employee> EMPLOYEES = Arrays.asList(
            new Employee(1,"Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", false),
            new Employee(2,"Martin", "Amandine", "Directrice Commercial", "Commercial", "amandine@lamzone.com", true),
            new Employee(3,"Gagné", "Paul", "Développeur", "Technique", "paul@lamzone.com", false),
            new Employee(4,"Tremblay", "Antoine", "Direncteur Achats", "Achats", "antoine@lamzone.com", true),
            new Employee(5,"Dupont", "Viviane", "Assistante", "Commercial", "viviane@lamzone.com", false),
            new Employee(6,"Côté", "Justin", "Directeur RH", "RH", "justin@lamzone.com", true),
            new Employee(7,"Lapointe", "Gaelle", "Développeuse", "Technique", "gaelle@lamzone.com", false),
            new Employee(8,"Leblanc", "Martin", "Comptable", "Finance", "martin@lamzone.com", true),
            new Employee(9,"Poirier", "Luc", "Assistant Marketing", "Marketing", "luc@lamzone.com", false),
            new Employee(10,"Fournier", "Agathe", "Directrice Marketing", "Marketing", "agathe@lamzone.com", true),
            new Employee(11,"Thibault", "Chris", "Directeur Technique", "Technique", "chris@lamzone.com", true)
    );

    public static List<Employee> generateEmployees() { return new ArrayList<>(EMPLOYEES); }


    public static List<Employee> FAKE_PARTICIPANTS_1 = Arrays.asList(
            new Employee(1,"Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com", false),
            new Employee(2,"Martin", "Amandine", "Directrice Commercial", "Commercial", "amandine@lamzone.com", true),
            new Employee(3,"Gagné", "Paul", "Développeur", "Technique", "paul@lamzone.com", false)
    );

    static List<Employee> generateFakeParticipants1() { return new ArrayList<>(FAKE_PARTICIPANTS_1); }

    public static List<Employee> FAKE_PARTICIPANTS_2 = Arrays.asList(
            new Employee(4,"Tremblay", "Antoine", "Direncteur Achats", "Achats", "antoine@lamzone.com", true),
            new Employee(5,"Dupont", "Viviane", "Assistante", "Commercial", "viviane@lamzone.com", false),
            new Employee(6,"Côté", "Justin", "Directeur RH", "RH", "justin@lamzone.com", true),
            new Employee(7,"Lapointe", "Gaelle", "Développeuse", "Technique", "gaelle@lamzone.com", false),
            new Employee(8,"Leblanc", "Martin", "Comptable", "Finance", "martin@lamzone.com", true)
    );
    static List<Employee> generateFakeParticipants2() { return new ArrayList<>(FAKE_PARTICIPANTS_2); }

    public static List<Employee> FAKE_PARTICIPANTS_3 = Arrays.asList(
            new Employee(9,"Poirier", "Luc", "Assistant Marketing", "Marketing", "luc@lamzone.com", false),
            new Employee(10,"Fournier", "Agathe", "Directrice Marketing", "Marketing", "agathe@lamzone.com", true),
            new Employee(11,"Thibault", "Chris", "Directeur Technique", "Technique", "chris@lamzone.com", true)
    );
    static List<Employee> generateFakeParticipants3() { return new ArrayList<>(FAKE_PARTICIPANTS_3); }

    public static Date addDays(Date d)  {
        int days = new Random().nextInt(8);
        d.setTime(d.getTime() + days * 1000L * 60L * 60L * 24L);
        return d;
    }

    public static List<Meeting> Dummy_Meetings = Arrays.asList(
            new Meeting(1,"Subject A",generateMeetingRooms().get(6),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants2())),
            new Meeting(2,"Subject B",generateMeetingRooms().get(2),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants1())),
            new Meeting(3,"Subject C",generateMeetingRooms().get(5),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateEmployees())),
            new Meeting(4,"Subject D",generateMeetingRooms().get(7),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants2())),
            new Meeting(5,"Subject E",generateMeetingRooms().get(3),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateEmployees())),
            new Meeting(6,"Subject F",generateMeetingRooms().get(9),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants3())),
            new Meeting(7,"Subject I",generateMeetingRooms().get(1),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants2())),
            new Meeting(8,"Subject J",generateMeetingRooms().get(4),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants1())),
            new Meeting(9,"Subject K",generateMeetingRooms().get(0),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateEmployees())));

   public static List<Meeting> generateMeetings() { return new ArrayList<>(Dummy_Meetings); }

    public static List<Meeting> Dummy_Random_Meetings = Arrays.asList(
            new Meeting(10,"Subject L",generateMeetingRooms().get(7),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants2())),
            new Meeting(11,"Subject M",generateMeetingRooms().get(9),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants3())),
            new Meeting(12,"Subject N",generateMeetingRooms().get(8),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateEmployees())),
            new Meeting(13,"Subject O",generateMeetingRooms().get(6),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants2())),
            new Meeting(14,"Subject P",generateMeetingRooms().get(4),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),new ArrayList<Employee>(generateFakeParticipants1())));


    }

