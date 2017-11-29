/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.bean;

import com.ag.beanI.UserBeanI;
import com.ag.dao.UserDao;
import com.ag.factory.DaoFactory;
import com.ag.factory.DaoType;
import com.ag.model.User;
import com.xag.util.BcryptPassword;
import static com.xag.util.BcryptPassword.checkPassword;
import com.xag.util.NoMatchFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author agunga
 */
@Service
@Stateless
public class UserBean implements UserBeanI {

    Logger log = LoggerFactory.getLogger(UserBean.class);

    @PersistenceContext
    EntityManager em;

//    EntityManager em = Persistence.createEntityManagerFactory("eventaPU").createEntityManager();

    public UserDao getDao() {
        log.info(" em :::::::::;" + em);
        return (UserDao) new DaoFactory(DaoType.USER).getDao(em);
    }

    @Override
    public User add(User user) {

        System.out.println("In UserBean Before User Save :  "+ user.getEmail() + " " + user.getPhone() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getPassword() + " " + user.getGender() + " " + user.getDateCreated());

        user.setPassword(BcryptPassword.hashPassword(user.getPassword()));

        try {
            return getDao().save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User update(User o) {
        try {
            return getDao().merge(o);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return getDao().findAll();
    }

    @Override
    public User findById(long id) {
        try {
            return getDao().findById(id);
        } catch (NoMatchFoundException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(User o) {
        return getDao().remove(o);
    }

    @Override
    public int delete(long id) {
        return getDao().removeById(id);
    }

    @Override
    public User authenticate(String username, String password) {

        User u = getDao().findByUsername(username);
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
        User u = authenticate(username, password);
        if (u == null) {
            return false;
        }
        String hashedNewPassword = BcryptPassword.hashPassword(newPassword);
        return (getDao().updatePassword(username, hashedNewPassword) > 0);
    }

}
