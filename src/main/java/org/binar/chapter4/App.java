package org.binar.chapter4;

import org.binar.chapter4.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	MenuService menu;

	@Override
	public void run(String... args) throws Exception {
//		Scanner scan = new Scanner(System.in);
//		menu.init(scan);
//		scan.close();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
