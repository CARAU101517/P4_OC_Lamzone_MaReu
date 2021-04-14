package com.example.mareu.model;

import com.example.mareu.service.DummyMeetingGenerator;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.example.mareu.service.DummyMeetingGenerator.Dummy_Random_Meetings;

public class Meeting {

    /**
     * Identifier
     */
    private long id;

    /**
     * Meeting subject
     */
    private String subject;

    /**
     * Localisation
     */
    private MeetingRoom localisation;

    /**
     * Start Date
     */
    private Date startDate;

    /**
     * End Date
     */
    private Date endDate;

    /**
     * Participants
     */

    private ArrayList<Employee> participants;

    /**
     * Constructor
     */

    public Meeting(long id, String subject, MeetingRoom localisation,
                   Date startDate, Date endDate, ArrayList<Employee> participants) {
        this.id = id;
        this.subject = subject;
        this.localisation = localisation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.participants = participants;
    }

    /** Setter and getter */

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() { return subject;  }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MeetingRoom getLocalisation() { return localisation; }

    public void setLocalisation(MeetingRoom localisation) {
        this.localisation = localisation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public ArrayList<Employee> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Employee> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Meeting random() {
        return Dummy_Random_Meetings.get(new Random().nextInt(Dummy_Random_Meetings.size()));
    }
}
