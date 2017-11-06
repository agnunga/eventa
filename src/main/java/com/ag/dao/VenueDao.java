/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Venue;

import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class VenueDao extends GenericDao<Venue, Long> {

    private final EntityManager em;

    public VenueDao(EntityManager em) {
        super(Venue.class, em);
        this.em = em;
    }

}
