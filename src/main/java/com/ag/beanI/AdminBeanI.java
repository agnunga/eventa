/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Admin;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author agunga
 */
@Local
public interface AdminBeanI {

    /**
     *
     * @param o
     * @return
     */
    Admin add(Admin o);

    /**
     *
     * @param o
     * @return
     */
    Admin update(Admin o);

    /**
     *
     * @return
     */
    List<Admin> findAll();

    /**
     *
     * @param id
     * @return
     */
    Admin findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(Admin o);

    /**
     *
     * @param Adminname
     * @param password
     * @return
     */
    Admin authenticate(String Adminname, String password);

    /**
     *
     * @param Adminname
     * @param password
     * @param newPassword
     * @return
     */
    boolean changePassword(String Adminname, String password, String newPassword);

    /**
     *
     * @param id
     * @return number of deleted items
     */
    int delete(long id);

}
