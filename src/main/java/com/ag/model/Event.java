/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.EventCategory;
import com.ag.type.EventStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "events")
@NamedQueries({})
public class Event implements Serializable {

    public Event() {
    }

    public Event(String name, EventStatus status, String description, EventCategory category, long maxAttendance, Venue venue, LocalDateTime eventDate, Admin addedBy, LocalDateTime dateAdded) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.category = category;
        this.maxAttendance = maxAttendance;
        this.venue = venue;
        this.eventDate = eventDate;
        this.addedBy = addedBy;
        this.dateAdded = dateAdded;
    }

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String eventCode;
    private String name;
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventCategory category;
    private long maxAttendance;
    @ManyToOne
    private Venue venue;
    /*@OneToMany
    private List <Ticket> tickets;*/

    @OneToMany
    List<Image> images;

    private LocalDateTime eventDate;
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

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public long getMaxAttendance() {
        return maxAttendance;
    }

    public void setMaxAttendance(long maxAttendance) {
        this.maxAttendance = maxAttendance;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
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

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
}
