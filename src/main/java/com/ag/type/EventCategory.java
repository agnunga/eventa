package com.ag.type;

/**
 * Created by agufed on 10/21/17.
 */
public enum EventCategory {
    COMEDY("Comedy"),
    CONCERT("Concert"),
    CINEMA("Cinema"),
    SEMINAR("Seminar");

    private final String name;

    private EventCategory(String name){
        this.name = name;
    }
}
