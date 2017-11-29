package com.ag.action;

import com.ag.beanI.AdminBeanI;
import com.ag.model.Admin;
import com.ag.model.User;
import com.ag.type.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */

@Controller
@RequestMapping("/admin")
public class AdminAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(AdminAction.class);

    @EJB(mappedName = "java:global/eventa/AdminBean")
    AdminBeanI adminBean;

    @RequestMapping("/")
    public @ResponseBody List<Admin> getActiveAdmin(){
        log.info("AdminAction...");
        return adminBean.findAll();
    }

//    @RequestMapping("all_users")
//    public Resolution getAllAdmin(){
//        log.info("getAllUser...");
//        return sendResponse(getJsonString(adminBean.findAll()), "success");
//    }
//
//    //
//    @RequestMapping("add")
//    public Resolution addAdmin(){
//        log.info("addAdmin... ");
//        Admin admin =  new Admin(user, username, role, LocalDateTime.now());
//        try {
//            return sendResponse(getJsonString(adminBean.add(admin)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
//            return sendResponse(getJsonString(user), "failed");
//        }
//    }
//
//    //
//    @RequestMapping("process_login")
//    public Resolution processLogin(){
//        try{
//            User user = adminBean.authenticate(username, getUser().getPassword());
//            return sendResponse(getJsonString(user), "success");
//        }catch(Exception e) {
//            log.info("Exception : " + e.getMessage());
//            return sendResponse(getJsonString(null), "failed");
//        }
//    }
//
//    @RequestMapping("change_password")
//    public Resolution changePassword(){
//        log.info("changePassword...");
//        return new ForwardResolution("/a/pages/changePassword.jsp");
//    }
//
//    @RequestMapping("process_change_password")
//    public Resolution processChangePassword(){
//        log.info("processChangePassword...");
//        return new ForwardResolution("/a/pages/changePassword.jsp");
//    }

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
