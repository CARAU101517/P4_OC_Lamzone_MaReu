package com.example.mareu.service;


import androidx.core.content.ContextCompat;

import com.example.mareu.R;
import com.example.mareu.model.Employee;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.MeetingRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
            new Employee(1,"Durand", "Alex", "Commercial", "Commercial", "alex@lamzone.com"),
            new Employee(2,"Martin", "Amandine", "Directrice Commercial", "Commercial", "amandine@lamzone.com"),
            new Employee(3,"Gagné", "Paul", "Développeur", "Technique", "paul@lamzone.com"),
            new Employee(4,"Tremblay", "Antoine", "Direncteur Achats", "Achats", "antoine@lamzone.com"),
            new Employee(5,"Dupont", "Viviane", "Assistante", "Commercial", "viviane@lamzone.com"),
            new Employee(6,"Côté", "Justin", "Directeur RH", "RH", "justin@lamzone.com"),
            new Employee(7,"Lapointe", "Gaelle", "Développeuse", "Technique", "gaelle@lamzone.com"),
            new Employee(8,"Leblanc", "Martin", "Comptable", "Finance", "martin@lamzone.com"),
            new Employee(9,"Poirier", "Luc", "Assistant Marketing", "Marketing", "luc@lamzone.com"),
            new Employee(10,"Fournier", "Agathe", "Directrice Marketing", "Marketing", "agathe@lamzone.com"),
            new Employee(11,"Thibault", "Chris", "Directeur Technique", "Technique", "chris@lamzone.com")
    );
    public static List<Employee> generateEmployees() { return new ArrayList<>(EMPLOYEES); }

    public static List<Meeting> Dummy_Meetings = Arrays.asList(
    );

    public static List<Meeting> generateMeetings() { return new ArrayList<>(Dummy_Meetings); }


}

