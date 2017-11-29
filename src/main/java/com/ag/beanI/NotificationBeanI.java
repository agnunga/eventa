/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Notification;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author agunga
 */
@Local
public interface NotificationBeanI {

    /**
     * @param o is the object to be updated
     * @return the added Notification
     */
    Notification add(Notification o);

    /**
     *
     * @param o is the object to be updated
     * @return the updated Notification
     */
    Notification update(Notification o);

    /**
     *
     * @author agunga
     * @return a List of Catalogs
     */
    List<Notification> findAll();

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return a Notification object
     */
    Notification findById(long o);

    /**
     *
     * @author agunga
     * @param o is the primaryId
     * @return true if the deletion was successful
     */
    boolean delete(Notification o);

    int delete(long id);

    void send();

}
