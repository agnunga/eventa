/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Venue;
import com.ag.model.Payment;
import com.ag.type.PaymentStatus;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class PaymentDao extends GenericDao<Payment, Long> {

    EntityManager em;

    public PaymentDao(EntityManager entityManager) {
        super(Payment.class, entityManager);
        this.em = entityManager;

    }

}
