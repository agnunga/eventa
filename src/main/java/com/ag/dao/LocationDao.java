/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Location;
import com.ag.model.Venue;
import com.ag.type.VenueStatus;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class LocationDao extends GenericDao<Location, Long> {

    EntityManager em;

    public LocationDao(EntityManager entityManager) {
        super(Location.class, entityManager);
        this.em = entityManager;

    }
}
