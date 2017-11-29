package com.ag.action;

import com.ag.beanI.LocationBeanI;
import com.ag.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by agufed on 10/21/17.
 */
@Controller
@RequestMapping("/locations")
public class LocationAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(LocationAction.class);

    @EJB(mappedName = "java:global/eventa/LocationBean")
    LocationBeanI locationBean;

    @RequestMapping("/")
    public @ResponseBody List<Location> getAlllocations(){
        log.info("getAlllocations...");
        return locationBean.findAll();
    }
//
//    //
//    @RequestMapping("add")
//    public Resolution addlocation(){
//        log.info("addlocation...");
//        Location location = new Location(name, description, longitude, latitude, getAdmin(), LocalDateTime.now());
//        try{
//            return sendResponse(getJsonString(locationBean.add(location)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
//            return sendResponse("Failed", "failed");
//        }
//    }

    //variables and setters
    private String name;
    private String description;
    private double longitude;
    private double latitude;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
