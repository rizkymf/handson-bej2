package org.binar.chapter4.service;

import org.springframework.stereotype.Service;

@Service
public class IEmailService {

    public void sendEmail() {
        System.out.println("email has been sent!");
    }
}
