/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Admin;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author agunga
 */
public class AdminDao extends GenericDao<Admin, Long> {

    EntityManager em;

    public AdminDao(EntityManager entityManager) {
        super(Admin.class, entityManager);
        this.em = entityManager;
    }

    public Admin findByUsername(String username) {
        try {
            return (Admin) em.createQuery("SELECT u FROM Admin u WHERE u.username =:username ")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public int updatePassword(String username, String hashedNewPassword) {
        return em.createQuery("UPDATE User u SET u.password = " + hashedNewPassword + " WHERE u.username =:username ")
                .setParameter("username", username).executeUpdate();
    }
}
