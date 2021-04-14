package com.example.mareu.model;

import android.graphics.Color;

import java.util.Objects;


public class MeetingRoom {
    /**
     * Identified
     */
    private int id;

    /**
     * Avatar MeetingRoom
     */
    private int avatarMeetingRoom;

    /**
     * Room Name
     */
    private String roomName;

    /**
     * Place
     */
    private String place;

    /**
     * Capacity
     */
    private int capacity;



   /**
     * Constructor
     */

    public MeetingRoom(int id, int avatarMeetingRoom, String roomName, String place, int capacity) {
        this.id = id;
        this.avatarMeetingRoom = avatarMeetingRoom;
        this.roomName = roomName;
        this.place = place;
        this.capacity = capacity;
    }

    /** Setter and getter */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvatarMeetingRoom() {
        return avatarMeetingRoom;
    }

    public void setAvatarMeetingRoom(int avatarMeetingRoom) {
        this.avatarMeetingRoom = avatarMeetingRoom; }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity;  }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingRoom meetingRoom = (MeetingRoom) o;
        return Objects.equals(id, meetingRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return roomName;
    }


}


