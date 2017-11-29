package com.ag.action;

import com.ag.beanI.TicketBeanI;
import com.ag.model.Audience;
import com.ag.model.Event;
import com.ag.model.Payment;
import com.ag.model.Ticket;
import com.ag.type.PaymentStatus;
import com.ag.type.TicketStatus;
import com.ag.type.TicketType;
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
@RequestMapping("/tickets")
public class TicketAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(TicketAction.class);

    @EJB(mappedName = "java:global/eventa/TicketBean")
    TicketBeanI ticketBean;

    @RequestMapping("/")
    public @ResponseBody
    List<Ticket> getAllTickets(){
        log.info("getAllTickets...");
        return ticketBean.findAll();
    }

//
//    //
//    @RequestMapping("add")
//    public Resolution addPayments(){
//        log.info("addPayments...");
//        Ticket ticket = new Ticket(event, ticketType, price, TicketStatus.BOOKED, getAudience(), LocalDateTime.now());
//        try {
//            return sendResponse(getJsonString(ticketBean.add(ticket)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
//            return sendResponse("Failed", "failed");
//        }
//    }
//

    //variables and setters
    private Event event;
    private TicketType ticketType;
    private double price;

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
