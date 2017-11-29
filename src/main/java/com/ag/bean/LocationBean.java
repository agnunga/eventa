/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.LocationBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.dao.LocationDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Location;
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
public class LocationBean implements LocationBeanI {

    Logger log = LoggerFactory.getLogger(LocationBean.class);

    @PersistenceContext(unitName = "eventaPU")
    EntityManager em;

    @EJB
    VenueBeanI venueBean;

    public LocationDao getDao() {
        return (LocationDao) new DaoFactory(DaoType.LOCATION).getDao(em);
    }

    @Override
    public Location add(Location o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Location update(Location o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Location> findAll() {
        return getDao().findAll();
    }

    @Override
    public Location findById(long id) throws NoMatchFoundException {
        return getDao().findById(id);
    }

    @Override
    public boolean delete(Location o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

}
