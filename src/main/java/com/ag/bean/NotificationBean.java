/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.EventBeanI;
import com.ag.beanI.NotificationBeanI;
import com.ag.beanI.NotificationBeanI;
import com.ag.dao.NotificationDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Notification;
import com.ag.type.PCUnitName;
import com.google.gson.Gson;
import com.xag.util.NoMatchFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author agunga
 */
@Stateless
public class NotificationBean implements NotificationBeanI {

    @Inject
    EventBeanI eventBean;

    Logger log = LoggerFactory.getLogger(NotificationBean.class);

    @PersistenceContext(unitName = PCUnitName.EVENTAPU)
    EntityManager em;

    @EJB
    NotificationBeanI cbi;

    public NotificationDao getDao() {
        return (NotificationDao) new DaoFactory(DaoType.NOTIFICATION).getDao(em);
    }

    @Override
    public Notification add(Notification o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Notification update(Notification o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Notification> findAll() {
        return getDao().findAll();
    }

    @Override
    public Notification findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean delete(Notification o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    @Schedule(minute="*/15", hour="*")
    public void send() {
        log.info("======Every Minute======");
        Gson gson = new Gson();
        log.info("====ConsistentEvents====\n" + gson.toJson(eventBean.findAll()));
    }
}
