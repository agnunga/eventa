/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Event;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class EventDao extends GenericDao<Event, Long> {

    EntityManager em;

    public EventDao(EntityManager entityManager) {
        super(Event.class, entityManager);
        this.em = entityManager;
    }

}
