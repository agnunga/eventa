package com.ag.action;

import com.ag.bean.EventBean;
import com.ag.bean.UserBean;
import com.ag.beanI.EventBeanI;
import com.ag.beanI.UserBeanI;
import com.ag.model.Event;
import com.ag.model.User;
import com.ag.type.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */
@Controller
//@RequestMapping("/users")
public class UserAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(UserAction.class);

    @EJB(mappedName = "java:global/eventa/EventBean")
    EventBeanI eventBean;

    /*@Autowired
    private EventBean eventBean;*/

    @EJB(mappedName = "java:global/eventa/UserBean")
    UserBeanI userBean;

    /*@Autowired
    private UserBean userBean;*/

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers(){
        log.info("getActiveUser...");
        return userBean.findAll();
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String userForm(Model model) {
        log.info("userForm form...");
        model.addAttribute("user", new User());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String userSubmit(@ModelAttribute(value = "user") User user, Model model) {
        log.info("userSubmit result...");
        model.addAttribute("name", "OLoo");
        log.info("The user :::: "+ user+"  "+user.getFirstName() + " " + user.getLastName());
//        userBean.add(user);
        return "result";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String userSubmit(@RequestParam("id") long id, Model model) {
        log.info("userSubmit load ...");
        User user = userBean.findById(id);
        model.addAttribute("user", user);
        return "load";
    }

    @RequestMapping(value = "/getjson", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getJson() {
        //your logic
        try {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userBean.findAll());
        }catch (IOException e){
            log.info("failed");
        }
        return "";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    @ResponseBody
    public String post(@RequestBody String json) {
        User pj = new User();
        ObjectMapper mapper = new ObjectMapper();
        try {
            pj = mapper.readValue(json, User.class);
            //do some things with json, put some header information in json
            return mapper.writeValueAsString(pj);
        }catch (IOException e){
            log.info("failed");
        }
        return "failed";
    }

//
//    //
//    @RequestMapping("login")
//    public Resolution login(){
//        log.info("login");
//        return new ForwardResolution("/pages/login.jsp");
//    }
//
//    //
//    @RequestMapping("register")
//    public Resolution register(){
//        log.info("register");
//        return new ForwardResolution("/pages/register.jsp");
//    }
//
//    //
//    @RequestMapping("add")
//    public Resolution processRegister(){
//        log.info("processRegister... ");
//        User user =  new User(email, phone, firstName, lastName, password, gender, LocalDateTime.now());
//        try {
//            return sendResponse(getJsonString(userBean.add(user)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
////            return sendResponse(getJsonString(user), "failed");
//            return sendResponse("{\"message\" : \"Registration Failed. Someone with the same phone or email already exists\"}", "failed");
//        }
//    }
//
//    //
//    @RequestMapping("process_login")
//    public Resolution processLogin(){
//        log.info("processLogin .... phone " + phone+" password " + password);
//        try{
//            User user = userBean.authenticate(phone, password);
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
//        return new ForwardResolution("/pages/changePassword.jsp");
//    }
//
//    @RequestMapping("process_change_password")
//    public Resolution processChangePassword(){
//        log.info("processChangePassword...");
//        return new ForwardResolution("/pages/changePassword.jsp");
//    }

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
