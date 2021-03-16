package com.example.mareu.model;

import java.util.Objects;


public class MeetingRoom {
    /**
     * Identified
     */
    private long id;

    /**
     * Avatar MeetingRoom
     */
    private String avatarMeetingRoom;

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

    public MeetingRoom(long id, String avatarMeetingRoom, String roomName, String place, int capacity) {
        this.id = id;
        this.avatarMeetingRoom = avatarMeetingRoom;
        this.roomName = roomName;
        this.place = place;
        this.capacity = capacity;
    }

    /** Setter and getter */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatarMeetingRoom() {
        return avatarMeetingRoom;
    }

    public void setAvatarMeetingRoom(String avatarMeetingRoom) {
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

}


