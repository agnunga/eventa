/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Location;
import com.ag.model.Venue;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface LocationBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Location
     */
    Location add(Location o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Location
     */
    Location update(Location o);

    /**
     *
     * @param id is the primary key
     * @param o is the object to be updated
     * @return the updated Location
     */
//    Location update(long id, Location o);
    /**
     *
     * @author agunga
     * @return a List of Shipments
     */
    List<Location> findAll();

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return a Location object
     * @throws com.xag.util.NoMatchFoundException
     */
    Location findById(long id) throws NoMatchFoundException;

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Location o);

    /**
     *
     * @author agunga
     * @param id is the primaryId
     * @return the number of deleted records
     */
    int delete(long id);

}
