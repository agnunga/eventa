/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "locations")
@NamedQueries({})
public class Location implements Serializable {

    public Location() {
    }

    public Location(String name, String description, double longitude, double latitude, Admin addedBy, LocalDateTime dateAdded) {
        this.name = name;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.addedBy = addedBy;
        this.dateAdded = dateAdded;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private double longitude;
    private double latitude;
    @ManyToOne
    private Admin addedBy;
    private LocalDateTime dateAdded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Admin getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Admin addedBy) {
        this.addedBy = addedBy;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}
