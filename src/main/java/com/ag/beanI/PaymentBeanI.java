/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.beanI;

import com.ag.model.Venue;
import com.ag.model.Payment;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author agunga
 */
@Local
public interface PaymentBeanI {

    /**
     *
     * @param o
     * @return Payment object
     */
    Payment add(Payment o);

    /**
     *
     * @param o
     * @return
     */
    Payment update(Payment o);

    /**
     *
     * @return
     */
    List<Payment> findAll();

    /**
     *
     * @param id
     * @return
     */
    Payment findById(long id);

    /**
     *
     * @param o
     * @return
     */
    boolean delete(Payment o);

    /**
     *
     * @param id
     * @return
     */
    int delete(long id);
}
