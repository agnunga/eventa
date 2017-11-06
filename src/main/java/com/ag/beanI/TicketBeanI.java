/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Ticket;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface TicketBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Ticket
     */
    Ticket add(Ticket o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Ticket
     */
    Ticket update(Ticket o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Ticket
     */
//    Ticket update(long id, Ticket o);
    /**
     *
     * @author agunga
     * @return a List of Books
     */
    List<Ticket> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Ticket object
     */
    Ticket findById(long id);

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Ticket o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

}
