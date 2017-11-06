package com.ag.action;

import com.ag.beanI.LocationBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.model.Location;
import com.ag.model.Payment;
import com.ag.model.Venue;
import com.ag.type.PaymentStatus;
import com.ag.type.VenueStatus;
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
@UrlBinding("/venues")
public class VenueAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(VenueAction.class);

    @Inject
    VenueBeanI venueBean;

    @Inject
    LocationBeanI locationBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getVenues(){
        log.info("getVenues...");
        return sendResponse(getJsonString(venueBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addVenue(){
        log.info("addVenue..." + name + " " + capacity + " loc Id " + location);
        try {
            Location l = locationBean.findById(location);
            log.info("Locations name + id : " + l.getName() + " " + l.getId());
            Venue venue = new Venue(name, capacity, l, VenueStatus.NEW, LocalDateTime.now());
            return sendResponse(getJsonString(venueBean.add(venue)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse("Failed", "failed");
        }
    }

    //variables and setters
    private String name;
    private long capacity;
    private long location;

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void setLocation(long location) {
        this.location = location;
    }
}
