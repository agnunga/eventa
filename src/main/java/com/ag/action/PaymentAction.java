package com.ag.action;

import com.ag.beanI.PaymentBeanI;
import com.ag.model.Audience;
import com.ag.model.Payment;
import com.ag.type.PaymentMode;
import com.ag.type.PaymentStatus;
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
@RequestMapping("/payments")
public class PaymentAction extends BaseActionBean {

    private Logger log = LoggerFactory.getLogger(PaymentAction.class);

    @EJB(mappedName = "java:global/eventa/PaymentBean")
    PaymentBeanI paymentBean;

    @RequestMapping("/")
    public @ResponseBody List<Payment> getAllPayments(){
        log.info("getAllPayments...");
        return paymentBean.findAll();
    }
//
//    //
//    @RequestMapping("add")
//    public Resolution addPayments(){
//        log.info("addPayments...");
//        Payment payment = new Payment(amount, paymentCode, paymentMode, PaymentStatus.NEW, getAudience(), LocalDateTime.now());
//        try {
//            return sendResponse(getJsonString(paymentBean.add(payment)), "success");
//        }catch (Exception e){
//            log.info("Exception : " + e.getMessage());
//            return sendResponse("Failed", "failed");
//        }
//    }


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
