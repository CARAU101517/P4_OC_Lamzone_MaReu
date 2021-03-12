package com.example.mareu.model;

import java.util.Objects;

public class Employee {

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
    private String position;

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

    public Employee(String lastName, String firstName, String position, String department, String email, boolean planner) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = position;
        this.department = department;
        this.email = email;
        this.planner = planner;
    }

    public Employee() {

    }

    /** Setter and getter */

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        return Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

}
