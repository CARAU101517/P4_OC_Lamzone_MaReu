package com.example.mareu.model;

import java.util.Objects;

public class Material {

    /**
     * Identifier
     */
    private long id;

    /**
     * Material type
     */
    private String type;


    /**
     * Constructor
     */

    public Material(long id, String type) {
        this.id = id;
        this.type = type;
    }

    /** Setter and getter */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
