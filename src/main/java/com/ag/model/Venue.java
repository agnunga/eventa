/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.EventStatus;
import com.ag.type.VenueStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "venues")
@NamedQueries({})
public class Venue implements Serializable {

    public Venue() {
    }

    public Venue(String name, long capacity, Location location, VenueStatus status, LocalDateTime dateAdded) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long capacity;
    @ManyToOne
    private Location location;
    @Enumerated(EnumType.STRING)
    private VenueStatus status;
    private LocalDateTime dateAdded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VenueStatus getStatus() {
        return status;
    }

    public void setStatus(VenueStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
