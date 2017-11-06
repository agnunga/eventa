package com.ag.action;

import com.ag.beanI.LocationBeanI;
import com.ag.model.Location;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by agufed on 10/21/17.
 */
@UrlBinding("/locations")
public class LocationAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(LocationAction.class);

    @Inject
    LocationBeanI locationBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getAlllocations(){
        log.info("getAlllocations...");
        return sendResponse(getJsonString(locationBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addlocation(){
        log.info("addlocation...");
        Location location = new Location(name, description, longitude, latitude, getAdmin(), LocalDateTime.now());
        try{
            return sendResponse(getJsonString(locationBean.add(location)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse("Failed", "failed");
        }
    }

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
