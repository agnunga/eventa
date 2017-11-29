/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.TicketBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.dao.VenueDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Venue;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Stateless
public class VenueBean implements VenueBeanI {

    Logger log = LoggerFactory.getLogger(VenueBean.class);

    @PersistenceContext(unitName = "eventaPU")
    EntityManager em;

    @EJB
    TicketBeanI rbi;

    VenueDao venueDao = null;

    public VenueDao getDao() {
        if(venueDao == null)
            venueDao = (VenueDao) new DaoFactory(DaoType.VENUE).getDao(em);
        return venueDao;
    }

    @Override
    public Venue add(Venue o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Venue update(Venue o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Venue> findAll() {
        return getDao().findAll();
    }

    @Override
    public Venue findById(long id) {

        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Venue o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }
    @EJB
    UserBeanI userBeanI;

}
