/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.UserRole;

import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
//@Table(name = "admins", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
@NamedQueries({})
public class Admin extends User {

    /*@Id
    @GeneratedValue
    private long id;*/
    @Column(unique = true)
    private String username;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime dateAdded;

    public Admin() {
    }

    public Admin(User user, String username, UserRole role, LocalDateTime dateAdded) {
        this.username = username;
        this.role = role;
        this.dateAdded = dateAdded;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}
