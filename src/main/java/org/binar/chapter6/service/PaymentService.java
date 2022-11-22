package org.binar.chapter6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    IEmailService emailService;

    @Autowired
    InvoiceService invoiceService;

    public boolean handleIncomingPayment() {
        emailService.sendEmail();
        return true;
    }

    public boolean handleRefund() {
        return true;
    }
}
