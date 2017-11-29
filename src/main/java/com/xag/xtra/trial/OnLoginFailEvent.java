/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.xtra.trial;

import com.ag.model.Admin;
import com.xag.util.WriteLogsToFile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@Named("onLoginFail")
public class OnLoginFailEvent implements EventResource {

    Logger log = LoggerFactory.getLogger(Admin.class);

    @Override
    public String takeAction() {
        System.out.println("At takeAction()");

        InetAddress IP = null;
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(OnLoginFailEvent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            String message = "Failed login attempt from IP: " + IP;
            log.info(message);
            WriteLogsToFile.write("failed_login.log", message);
        }
        return "Failed login attempt logged.";
    }

}
