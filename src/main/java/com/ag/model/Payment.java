/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.model;

import com.ag.type.PaymentMode;
import com.ag.type.PaymentStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author agunga
 */
@Entity
@Table(name = "payments")
@NamedQueries({})
public class Payment implements Serializable {

    public Payment() {
    }

    public Payment(double amount, String paymentCode, PaymentMode paymentMode, PaymentStatus status, Audience paidBy, LocalDateTime datePaid) {
        this.amount = amount;
        this.paymentCode = paymentCode;
        this.paymentMode = paymentMode;
        this.status = status;
        this.paidBy = paidBy;
        this.datePaid = datePaid;
    }

    @Id
    @GeneratedValue
    private long id;
    private double amount;
    @Column(unique = true)
    private String receiptNo;
    @Column(unique = true)
    private String paymentCode;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    @ManyToOne
    private Audience paidBy;
    private LocalDateTime datePaid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Audience getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Audience paidBy) {
        this.paidBy = paidBy;
    }

    public LocalDateTime getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDateTime datePaid) {
        this.datePaid = datePaid;
    }
}
