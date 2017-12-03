/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.TicketStatus;
import com.ag.type.TicketType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "tickets")
@NamedQueries({})
public class Ticket implements Serializable {

    public Ticket() {
    }

    public Ticket(Event event, TicketType ticketType, double price, TicketStatus ticketStatus, Audience audience, LocalDateTime dateBooked) {
        this.event = event;
        this.ticketType = ticketType;
        this.price = price;
        this.ticketCode = ticketCode;
        this.ticketStatus = ticketStatus;
        this.audience = audience;
        this.dateBooked = dateBooked;
    }

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Event event;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private double price;
    @Column(unique = true)
    private String ticketCode;
    /*@OneToMany
    private List<Payment> payments;*/
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Audience audience;
    private LocalDateTime dateBooked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public LocalDateTime getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(LocalDateTime dateBooked) {
        this.dateBooked = dateBooked;
    }
}
