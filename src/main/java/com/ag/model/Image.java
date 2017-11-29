package com.ag.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by agufed on 11/6/17.
 */

@Entity
@Table(name = "images")
@NamedQueries({})
public class Image implements Serializable {

    public Image() {
    }

    public Image(String name, String description, String imageUrl, User addedBy, LocalDateTime dateAdded) {
        this.name = name;
        this.description = description;
        this.addedBy = addedBy;
        this.dateAdded = dateAdded;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private User addedBy;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
}

