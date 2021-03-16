package com.example.mareu.service;

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

    public static List<Meeting> Dummy_Meetings = Arrays.asList(
            new Meeting(1,"Subject A",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()), participants()),
            new Meeting(2,"Subject B",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()), participants()),
            new Meeting(3,"Subject C",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()), participants()),
            new Meeting(4,"Subject D",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(5,"Subject E",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(6,"Subject F",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(7,"Subject I",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(8,"Subject J",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(9,"Subject K",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants())
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(Dummy_Meetings); }

    public static List<Meeting> Dummy_Random_Meetings = Arrays.asList(
            new Meeting(10,"Subject L",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(11,"Subject M",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(12,"Subject N", localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(13,"Subject O",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants()),
            new Meeting(14,"Subject P",localisation(),addDays(Calendar.getInstance().getTime()),addDays(Calendar.getInstance().getTime()),participants())
    );

    public static Date addDays(Date d)  {
        int days = new Random().nextInt(8);
        d.setTime(d.getTime() + days * 1000L * 60L * 60L * 24L);
        return d;
    }

    public static List<MeetingRoom> MEETING_ROOMS = Arrays.asList(
            new MeetingRoom(1,"SydneyRoom", "Sydney", "RDC", 12),
            new MeetingRoom(2,"NewYorkRoom", "New York", "RDC", 5),
            new MeetingRoom(3,"LondonRoom", "London", "1er étage", 2),
            new MeetingRoom(4,"RioRoom", "Rio", "1er étage", 20),
            new MeetingRoom(5,"OsloRoom", "Oslo", "2ème", 6),
            new MeetingRoom(6,"CapeTownRoom", "Cape Town", "2ème étage", 12),
            new MeetingRoom(7,"VancouverRoom", "Vancouver", "2ème étage", 6),
            new MeetingRoom(8,"SingaporeRoom", "Singapore", "3ème", 6),
            new MeetingRoom(9,"ParisRoom", "paris", "3ème étage", 12)
            );

    static List<MeetingRoom> generateMeetingRooms() { return new ArrayList<>(MEETING_ROOMS); }

    public static MeetingRoom localisation(){
        return MEETING_ROOMS.get(new Random(1).nextInt(MEETING_ROOMS.size()));
    }

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

    static List<Employee> generateEmployees() { return new ArrayList<>(EMPLOYEES); }

    public static Employee participants() {
        return EMPLOYEES.get(new Random(4).nextInt(EMPLOYEES.size()));
    }

    }

