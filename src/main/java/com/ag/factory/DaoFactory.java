/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

import com.ag.dao.*;

import javax.persistence.EntityManager;

/**
 *
 * @author agunga
 */
public class DaoFactory {

    DaoType type;

    public DaoFactory(DaoType type) {
        this.type = type;
    }

    DaoFactory() {
    }

    public GenericDao getDao(EntityManager em) {
        switch (type) {
            case PAYMENT: {
                return new PaymentDao(em);
            }
            case VENUE: {
                return new VenueDao(em);
            }
            case EVENT: {
                return new EventDao(em);
            }
            case TICKET: {
                return new TicketDao(em);
            }
            case USER: {
                return new UserDao(em);
            }
            case LOCATION: {
                return new LocationDao(em);
            }
            case ADMIN: {
                return new AdminDao(em);
            }
            case AUDIENCE: {
                return new AudienceDao(em);
            }
            case NOTIFICATION: {
                return new NotificationDao(em);
            }
            default:
                return null;
        }
    }

    public GenericDao getDao(DaoType type, EntityManager em) {
        return new DaoFactory(type).getDao(em);
    }
}
