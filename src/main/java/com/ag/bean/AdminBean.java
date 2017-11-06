/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.*;
import com.ag.dao.AdminDao;
import com.ag.dao.UserDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.Admin;
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
public class AdminBean implements AdminBeanI {

    Logger log = LoggerFactory.getLogger(AdminBean.class);

    @PersistenceContext(unitName = "eventaPU")
    public EntityManager em;

    public AdminDao getDao() {
        return (AdminDao) new DaoFactory(DaoType.ADMIN).getDao(em);
    }

    @Override
    public Admin add(Admin o) {
        o.setPassword(BcryptPassword.hashPassword(o.getPassword()));

        try {
            return getDao().save(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Admin update(Admin o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Admin> findAll() {
        return getDao().findAll();
    }

    @Override
    public Admin findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Admin o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    public Admin authenticate(String username, String password) {

        Admin u = getDao().findByUsername(username);
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
        Admin u = authenticate(username, password);
        if (u == null) {
            return false;
        }
        String hashedNewPassword = BcryptPassword.hashPassword(newPassword);
        return (getDao().updatePassword(username, hashedNewPassword) > 0);
    }

}
