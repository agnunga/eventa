package com.ag.action;

import com.ag.beanI.NotificationBeanI;
import com.ag.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */
@Controller
@RequestMapping("/notifications")
public class NotificationAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(NotificationAction.class);

    @EJB(mappedName = "java:global/eventa/NotificationBean")
    NotificationBeanI notificationBean;

    @RequestMapping("default")
    public @ResponseBody List<Notification> getAllNotifications(){
        log.info("getAllNotifications...");
        return notificationBean.findAll();
    }

    //variables and setters

}
