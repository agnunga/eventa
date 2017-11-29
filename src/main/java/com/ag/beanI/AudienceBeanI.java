/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Audience;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author agunga
 */
@Local
public interface AudienceBeanI {

    /**
     *
     * @param o
     * @return
     */
    Audience add(Audience o);

    /**
     *
     * @param o
     * @return
     */
    Audience update(Audience o);

    /**
     *
     * @return
     */
    List<Audience> findAll();

    /**
     *
     * @param id
     * @return
     */
    Audience findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(Audience o);

    /**
     *
     * @param Audiencename
     * @param password
     * @return
     */
    Audience authenticate(String Audiencename, String password);

    /**
     *
     * @param Audiencename
     * @param password
     * @param newPassword
     * @return
     */
    boolean changePassword(String Audiencename, String password, String newPassword);

    /**
     *
     * @param id
     * @return number of deleted items
     */
    int delete(long id);

}
