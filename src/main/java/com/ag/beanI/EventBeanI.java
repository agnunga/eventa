/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Event;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface EventBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Event
     */
    Event add(Event o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Event
     */
    Event update(Event o);

    /**
     *
     * @author agunga
     * @return a List of Catalogs
     */
    List<Event> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Event object
     */
    Event findById(long o);

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Event o);

    int delete(long id);

}
