/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.EventBeanI;
import com.ag.dao.EventDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Event;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author agunga
 */
//@Service
@Stateless
public class EventBean implements EventBeanI {

    Logger log = LoggerFactory.getLogger(EventBean.class);

    @PersistenceContext(unitName = "eventaPU")
    EntityManager em;

    //EntityManager em = Persistence.createEntityManagerFactory("eventaPU").createEntityManager();

    public EventDao getDao() {
        return (EventDao) new DaoFactory(DaoType.EVENT).getDao(em);
    }

    @Override
    public Event add(Event o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Event update(Event o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Event> findAll() {
        return getDao().findAll();
    }

    @Override
    public Event findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean delete(Event o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

}
