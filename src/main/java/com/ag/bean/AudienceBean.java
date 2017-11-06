/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.*;
import com.ag.dao.AdminDao;
import com.ag.dao.AudienceDao;
import com.ag.dao.UserDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Audience;
import com.xag.util.BcryptPassword;
import com.xag.util.NoMatchFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.xag.util.BcryptPassword.checkPassword;

/**
 *
 * @author agunga
 */
@Stateless
public class AudienceBean implements AudienceBeanI {

    Logger log = LoggerFactory.getLogger(AudienceBean.class);

    @PersistenceContext(unitName = "eventaPU")
    public EntityManager em;

    public AudienceDao getDao() {
        return (AudienceDao) new DaoFactory(DaoType.AUDIENCE).getDao(em);
    }

    @Override
    public Audience add(Audience o) {
        o.setPassword(BcryptPassword.hashPassword(o.getPassword()));

        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Audience update(Audience o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Audience> findAll() {
        return getDao().findAll();
    }

    @Override
    public Audience findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Audience o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    public Audience authenticate(String username, String password) {

        Audience u = getDao().findByUsername(username);
        if (u != null) {
            if (checkPassword(password, u.getPassword())) {
                log.info("Login success!");
                return u;
            }
        }
        log.info("Login failed at nre exception");
        return null;
    }

    @Override
    public boolean changePassword(String username, String password, String newPassword
    ) {
        Audience u = authenticate(username, password);
        if (u == null) {
            return false;
        }
        String hashedNewPassword = BcryptPassword.hashPassword(newPassword);
        return (getDao().updatePassword(username, hashedNewPassword) > 0);
    }

}
