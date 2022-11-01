package org.binar.chapter4;

import org.binar.chapter4.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter4Application {


	public static void main(String[] args) {
		SpringApplication.run(Chapter4Application.class, args);
//		PaymentService paymentService = new PaymentService();
//		paymentService.handleIncomingPayment();
//		System.out.println("Hello world!");
	}

}
