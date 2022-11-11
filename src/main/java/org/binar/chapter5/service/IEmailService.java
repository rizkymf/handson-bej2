package org.binar.chapter5.service;

import org.springframework.stereotype.Service;

@Service
public class IEmailService {

    public void sendEmail() {
        System.out.println("email has been sent!");
    }
}
