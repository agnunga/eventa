/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.*;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface UserBeanI {

    /**
     *
     * @param o
     * @return
     */
    User add(User o);

    /**
     *
     * @param o
     * @return
     */
    User update(User o);

    /**
     *
     * @return
     */
    List<User> findAll();

    /**
     *
     * @param id
     * @return
     */
    User findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(User o);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User authenticate(String username, String password, boolean phone);

    /**
     *
     * @param username
     * @param password
     * @param newPassword
     * @return
     */
    boolean changePassword(String username, String password, String newPassword, boolean phone);

    /**
     *
     * @param id
     * @return number of deleted items
     */
    int delete(long id);

}
