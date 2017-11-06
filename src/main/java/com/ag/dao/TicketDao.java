/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Ticket;
import java.util.List;
import javax.persistence.EntityManager; 

/**
 *
 * @author agunga
 */
public class TicketDao extends GenericDao<Ticket, Long> {

    EntityManager em;

    public TicketDao(EntityManager entityManager) {
        super(Ticket.class, entityManager);
        this.em = entityManager;
    }
}
