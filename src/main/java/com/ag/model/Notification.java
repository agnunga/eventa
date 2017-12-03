/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.NotificationMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "notifications")
@NamedQueries({})
public class Notification implements Serializable {

    public Notification() {
    }

    public Notification(NotificationMode mode, String message, User sentTo, Admin initiatedBy, LocalDateTime dateAdded) {
        this.mode = mode;
        this.message = message;
        this.sentTo = sentTo;
        this.initiatedBy = initiatedBy;
        this.dateAdded = dateAdded;
    }

    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private NotificationMode mode;
    private String message;
    @ManyToOne
    private User sentTo;
    @ManyToOne
    private Admin initiatedBy;
    private LocalDateTime dateAdded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NotificationMode getMode() {
        return mode;
    }

    public void setMode(NotificationMode mode) {
        this.mode = mode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSentTo() {
        return sentTo;
    }

    public void setSentTo(User sentTo) {
        this.sentTo = sentTo;
    }

    public Admin getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(Admin initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}
