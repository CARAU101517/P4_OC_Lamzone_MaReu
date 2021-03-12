package com.example.mareu.model;

public class Participants extends Employee {


    /**
     * Constructor
     *
     * @param lastName
     * @param firstName
     * @param position
     * @param department
     * @param email
     * @param planner
     */
    public Participants(String lastName, String firstName, String position, String department, String email, boolean planner) {
        super(lastName, firstName, position, department, email, planner);
    }

    public Participants() {
        super();
    }
}
