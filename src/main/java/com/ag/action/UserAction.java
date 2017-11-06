package com.ag.action;

import com.ag.beanI.UserBeanI;
import com.ag.model.User;
import com.ag.type.Gender;
import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by agufed on 10/21/17.
 */
@UrlBinding("/users")
public class UserAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(UserAction.class);

    @Inject
    UserBeanI userBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getActiveUser(){
        log.info("getActiveUser...");
        return sendResponse(getJsonString(userBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("all_users")
    public Resolution getAllUser(){
        log.info("getAllUser...");
        return sendResponse(getJsonString(userBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("login")
    public Resolution login(){
        log.info("login");
        return new ForwardResolution("/pages/login.jsp");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("register")
    public Resolution register(){
        log.info("register");
        return new ForwardResolution("/pages/register.jsp");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution processRegister(){
        log.info("processRegister... ");
        User user =  new User(email, phone, firstName, lastName, password, gender, LocalDateTime.now());
        try {
            return sendResponse(getJsonString(userBean.add(user)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
//            return sendResponse(getJsonString(user), "failed");
            return sendResponse("{\"message\" : \"Registration Failed. Someone with the same phone or email already exists\"}", "failed");
        }
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("process_login")
    public Resolution processLogin(){
        log.info("processLogin .... phone " + phone+" password " + password);
        try{
            User user = userBean.authenticate(phone, password);
            return sendResponse(getJsonString(user), "success");
        }catch(Exception e) {
            log.info("Exception : " + e.getMessage());
            return sendResponse(getJsonString(null), "failed");
        }
    }

    @HandlesEvent("change_password")
    public Resolution changePassword(){
        log.info("changePassword...");
        return new ForwardResolution("/pages/changePassword.jsp");
    }

    @HandlesEvent("process_change_password")
    public Resolution processChangePassword(){
        log.info("processChangePassword...");
        return new ForwardResolution("/pages/changePassword.jsp");
    }

    //variables and setters
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private Gender gender;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
