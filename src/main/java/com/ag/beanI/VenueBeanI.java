/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Venue;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface VenueBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Venue
     */
    Venue add(Venue o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Venue
     */
    Venue update(Venue o);

    /**
     *
     * @author agunga
     * @return a List of BookTrackers
     */
    List<Venue> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Venue object
     */
    Venue findById(long id);

    /**
     *
     * @author agunga
     * @param o
     * @return true if the deletion was successful
     */
    boolean delete(Venue o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

}
