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
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.Consumes;
import java.io.IOException;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */
@RestController
@RequestMapping("/users")
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

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(){
        log.info("getActiveUser...");
        return userBean.findAll();
    }

    @RequestMapping(value = "/find{id}", method = RequestMethod.GET)
    public User findById(@RequestParam("id") long id) {
        log.info("findById ...");
        return userBean.findById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        log.info("addUser The user :::: " + user.getFirstName() + " " + user.getLastName());
        try{
            return userBean.add(user);
        }catch (Exception e){
            log.info("Error adding user ...");
            return null;
        }
    }

    @RequestMapping(value = "/update{id}", method = RequestMethod.PUT)
    public User updateUser(@RequestParam("id") long id, @RequestBody User user) {
        log.info("updateUser The user :::: " + user.getFirstName() + " " + user.getLastName());
        user.setId(id);
        try{
            return userBean.update(user);
        }catch (Exception e){
            log.info("Error updating user ...");
            return null;
        }
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam("id") long id) {
        log.info("deleteUser The user id = :::: " + id);
        try{
            return userBean.delete(id)+" user(s) deleted";
        }catch (Exception e){
            log.info("Error deleting user ...");
            return null;
        }
    }

    @RequestMapping(value = "/login{phone}{password}", method = RequestMethod.GET)
    public User processLogin(@RequestParam("phone") String phone, @RequestParam("password") String password){
        log.info("processLogin .... phone " + phone + " password " + password);
        try{
            return userBean.authenticate(phone, password, true);
        }catch(Exception e){
            log.info("Exception : " + e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/change_password{phone}{password}")
    public String changePassword(@RequestParam("phone") String phone, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword){
        log.info("changePassword...");
        return "Changed : " + userBean.changePassword(phone, password, newPassword, true);
    }

/*    @RequestMapping(value = "/form", method = RequestMethod.GET)
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
        userBean.add(user);
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
        log.info("json : " + json);
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
    }*/

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
