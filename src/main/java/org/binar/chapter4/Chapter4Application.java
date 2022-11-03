package org.binar.chapter4;

import org.binar.chapter4.menu.Menu;
import org.binar.chapter4.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Chapter4Application implements CommandLineRunner {

	@Autowired
	Menu menu;

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		menu.init(scan);
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter4Application.class, args);
	}

}
