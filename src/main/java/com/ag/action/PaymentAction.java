package com.ag.action;

import com.ag.beanI.PaymentBeanI;
import com.ag.model.Audience;
import com.ag.model.Payment;
import com.ag.type.PaymentMode;
import com.ag.type.PaymentStatus;
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
@UrlBinding("/payments")
public class PaymentAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(PaymentAction.class);

    @Inject
    PaymentBeanI paymentBean;

    @RolesAllowed(value= {"all"} )
    @DefaultHandler
    public Resolution getAllPayments(){
        log.info("getAllPayments...");
        return sendResponse(getJsonString(paymentBean.findAll()), "success");
    }

    @RolesAllowed(value= {"all"} )
    @HandlesEvent("add")
    public Resolution addPayments(){
        log.info("addPayments...");
        Payment payment = new Payment(amount, paymentCode, paymentMode, PaymentStatus.NEW, getAudience(), LocalDateTime.now());
        try {
            return sendResponse(getJsonString(paymentBean.add(payment)), "success");
        }catch (Exception e){
            log.info("Exception : " + e.getMessage());
            return sendResponse("Failed", "failed");
        }
    }


    //variables and setters
    private double amount;
    private String paymentCode;
    private PaymentMode paymentMode;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
