/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.TicketBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.dao.TicketDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Ticket;
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
//@DeclareRoles({"ADMIN", "CUSTOMER"})
public class TicketBean implements TicketBeanI {

    Logger log = LoggerFactory.getLogger(TicketBean.class);

    @PersistenceContext(unitName = "eventaPU")
    EntityManager em;

    @EJB
    VenueBeanI bbi;

    private TicketDao ticketDao = null;

    public TicketDao getDao() {
        if (ticketDao == null)
            ticketDao = (TicketDao) new DaoFactory(DaoType.TICKET).getDao(em);
        return ticketDao;
    }

    //    @RolesAllowed("ADMIN")
    @Override
    public Ticket add(Ticket o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Ticket update(Ticket o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ticket> findAll() {
        return getDao().findAll();
    }

    @Override
    public Ticket findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Ticket o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

}
