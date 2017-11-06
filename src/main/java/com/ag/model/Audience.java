/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
//@Table(name = "audience")
@NamedQueries({})
public class Audience extends User {



    /*@Id
    @GeneratedValue
    private long id;*/
    private Admin referredBy;
    /*@OneToMany
    private List<Ticket> tickets;*/

    /*@Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }*/

    public Admin getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(Admin referredBy) {
        this.referredBy = referredBy;
    }

}
