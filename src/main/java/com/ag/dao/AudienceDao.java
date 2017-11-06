/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.dao;

import com.ag.model.Admin;
import com.ag.model.Audience;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author agunga
 */
public class AudienceDao extends GenericDao<Audience, Long> {

    EntityManager em;

    public AudienceDao(EntityManager entityManager) {
        super(Audience.class, entityManager);
        this.em = entityManager;
    }

    public Audience findByUsername(String username) {
        try {
            return (Audience) em.createQuery("SELECT u FROM Audience u WHERE u.phone =:username ")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public int updatePassword(String username, String hashedNewPassword) {
        return em.createQuery("UPDATE Audience u SET u.password = " + hashedNewPassword + " WHERE u.username =:username ")
                .setParameter("username", username).executeUpdate();
    }
}
