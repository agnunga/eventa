package com.ag.action;

import com.ag.beanI.TicketBeanI;
import com.ag.model.Audience;
import com.ag.model.Event;
import com.ag.model.Payment;
import com.ag.model.Ticket;
import com.ag.type.PaymentStatus;
import com.ag.type.TicketStatus;
import com.ag.type.TicketType;
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
@UrlBinding("/tickets")
public class TicketAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(TicketAction.class);

    @Inject
    TicketBeanI ticketBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getAllTickets(){
        log.info("getAllTickets...");
        return sendResponse(getJsonString(ticketBean.findAll()), "success");
    }


    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addPayments(){
        log.info("addPayments...");
        Ticket ticket = new Ticket(event, ticketType, price, TicketStatus.BOOKED, getAudience(), LocalDateTime.now());
        try {
            return sendResponse(getJsonString(ticketBean.add(ticket)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse("Failed", "failed");
        }
    }


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
