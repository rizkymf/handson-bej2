package org.binar.chapter5.configuration;

import org.binar.chapter5.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Autowired
    PaymentService paymentService;

    @Value("${nama.lengkap}")
    String namaLengkap;

    @Value("${direktori.tmp}")
    String tmp;

    @Bean
    public void test() {
        paymentService.handleIncomingPayment();
        System.out.println("nama lengkap : " + namaLengkap);
        System.out.println("tmp : " + tmp);
    }
}
