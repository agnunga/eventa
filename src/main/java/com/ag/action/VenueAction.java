package com.ag.action;

import com.ag.beanI.LocationBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.model.Location;
import com.ag.model.Payment;
import com.ag.model.Venue;
import com.ag.type.PaymentStatus;
import com.ag.type.VenueStatus;
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
@RequestMapping("/venues")
public class VenueAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(VenueAction.class);

    @EJB(mappedName = "java:global/eventa/VenueBean")
    VenueBeanI venueBean;

    @EJB(mappedName = "java:global/eventa/LocationBean")
    LocationBeanI locationBean;

    //
    @RequestMapping("/")
    public @ResponseBody
    List<Venue> getVenues(){
        log.info("getVenues...");
        return venueBean.findAll();
    }

    //
//    @RequestMapping("add")
//    public Resolution addVenue(){
//        log.info("addVenue..." + name + " " + capacity + " loc Id " + location);
//        try {
//            Location l = locationBean.findById(location);
//            log.info("Locations name + id : " + l.getName() + " " + l.getId());
//            Venue venue = new Venue(name, capacity, l, VenueStatus.NEW, LocalDateTime.now());
//            return sendResponse(getJsonString(venueBean.add(venue)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
//            return sendResponse("Failed", "failed");
//        }
//    }

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
