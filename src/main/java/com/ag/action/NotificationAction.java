package com.ag.action;

import com.ag.beanI.NotificationBeanI;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

/**
 * Created by agufed on 10/21/17.
 */
@UrlBinding("/notifications")
public class NotificationAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(NotificationAction.class);

    @Inject
    NotificationBeanI notificationBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getAllNotifications(){
        log.info("getAllNotifications...");
        return sendResponse( getJsonString(notificationBean.findAll()), "success");
    }

    //variables and setters

}
