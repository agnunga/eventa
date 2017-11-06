/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Admin;
import com.ag.model.Notification;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author agunga
 */
public class NotificationDao extends GenericDao<Notification, Long> {

    EntityManager em;

    public NotificationDao(EntityManager entityManager) {
        super(Notification.class, entityManager);
        this.em = entityManager;
    }
}
