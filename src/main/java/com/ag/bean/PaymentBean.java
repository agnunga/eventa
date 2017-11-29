/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.PaymentBeanI;
import com.ag.dao.PaymentDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Venue;
import com.ag.model.Payment;
import com.xag.util.NoMatchFoundException;
import java.util.List;
import java.util.Queue;
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
public class PaymentBean implements PaymentBeanI {

    Logger log = LoggerFactory.getLogger(PaymentBean.class);

    @PersistenceContext(unitName = "eventaPU")
    EntityManager em;
    //    @Inject
//    JMSContext context;
//
//    @Resource(lookup = "java:/myJmsTest/MyQueue")
    private Queue queue;

    public PaymentDao getDao() {
        return (PaymentDao) new DaoFactory(DaoType.PAYMENT).getDao(em);
    }

    @Override
    public Payment add(Payment o) {
        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Payment update(Payment o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Payment> findAll() {
        return getDao().findAll();
    }

    @Override
    public Payment findById(long id) {

        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Payment o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    public void confirmation(long id) {
        try {
            Payment payment = getDao().findById(id);
            // context.createProducer().setTimeToLive(1000).send((Destination) queue, payment);
            log.info("Queued.");
            log.info("Wait for Notification.");
        } catch (NoMatchFoundException ex) {
            log.error("Payment not found." + ex.getMessage());
        }

    }

}
