package com.example.mareu.model;

import java.util.Objects;
import java.util.Random;

import static com.example.mareu.service.DummyMeetingGenerator.Dummy_Random_Meetings;

public class Employee {

    /**
     * Identified
     */
    private long id;

    /**
     * Last Name
     */
    private String lastName;

    /**
     * First Name
     */
    private String firstName;

    /**
     * Position
     */
    private String job;

    /**
     * Department
     */
    private String department;

    /**
     * Email
     */
    private String email;

    /**
     * Planner?
     */
    private boolean planner = false;


    /**
     * Constructor
     */

    public Employee(long id, String lastName, String firstName, String job, String department, String email, boolean planner) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.job = job;
        this.department = department;
        this.email = email;
        this.planner = planner;
    }


    /** Setter and getter */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPlanner() {
        return planner;
    }

    public void setPlanner(boolean planner) {
        this.planner = planner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
