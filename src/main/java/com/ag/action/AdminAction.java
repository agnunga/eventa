package com.ag.action;

import com.ag.beanI.AdminBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Admin;
import com.ag.model.User;
import com.ag.type.Gender;
import com.ag.type.UserRole;
import net.sourceforge.stripes.action.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by agufed on 10/21/17.
 */
@UrlBinding("/admin")
public class AdminAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(AdminAction.class);

    @Inject
    AdminBeanI adminBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getActiveAdmin(){
        log.info("getActiveUser...");
        return sendResponse(getJsonString(adminBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("all_users")
    public Resolution getAllAdmin(){
        log.info("getAllUser...");
        return sendResponse(getJsonString(adminBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addAdmin(){
        log.info("addAdmin... ");
        Admin admin =  new Admin(user, username, role, LocalDateTime.now());
        try {
            return sendResponse(getJsonString(adminBean.add(admin)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse(getJsonString(user), "failed");
        }
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("process_login")
    public Resolution processLogin(){
        try{
            User user = adminBean.authenticate(username, getUser().getPassword());
            return sendResponse(getJsonString(user), "success");
        }catch(Exception e) {
            log.info("Exception : " + e.getMessage());
            return sendResponse(getJsonString(null), "failed");
        }
    }

    @HandlesEvent("change_password")
    public Resolution changePassword(){
        log.info("changePassword...");
        return new ForwardResolution("/a/pages/changePassword.jsp");
    }

    @HandlesEvent("process_change_password")
    public Resolution processChangePassword(){
        log.info("processChangePassword...");
        return new ForwardResolution("/a/pages/changePassword.jsp");
    }

    //Getter and setters
    private User user;
    private String username;
    private UserRole role;

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }
}
