package com.ag.action;

import com.ag.beanI.EventBeanI;
import com.ag.model.Admin;
import com.ag.model.Event;
import com.ag.model.User;
import com.ag.model.Venue;
import com.ag.type.EventCategory;
import com.ag.type.EventStatus;
import com.google.gson.Gson;
import com.xag.util.MyJsonResult;
import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */
@UrlBinding("/events")
public class EventAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(EventAction.class);

    @Inject
    EventBeanI eventBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getAllUpcomingEvents(){
        log.info("getAllUpcomingEvents...");
        return sendResponse(getJsonString(eventBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("past")
    public Resolution getAllPastEvents(){
        log.info("getAllPastEvents...");
        return sendResponse(getJsonString(eventBean.findAll()), "success");
    }
    @RolesAllowed(value= {"all"} )
    @HandlesEvent("user")
    public Resolution getAllUserEvents(){
        try {
            return sendResponse(getJsonString(eventBean.findAll()), "success");
        }catch (Exception e){
            return sendResponse("users", "failed");
        }
    }


    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addEvent(){
        log.info("addEvent...");
        Event event = new Event(name, EventStatus.NEW, description, category, maxAttendance, venue, eventDate, getAdmin(), LocalDateTime.now());
        try {
            return sendResponse(getJsonString(eventBean.add(event)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse("failed", "failed");
        }
    }

    //forms
    @RolesAllowed(value= {"all"} )
    @HandlesEvent("addForm")
    public Resolution addForm(){
        log.info("addForm");
        return new ForwardResolution("/a/pages/register.jsp");
    }

    //variables and setters
    private String name;
    private String description;
    private EventCategory category;
    private long maxAttendance;
    private Venue venue;
    private LocalDateTime eventDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public void setMaxAttendance(long maxAttendance) {
        this.maxAttendance = maxAttendance;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

}
