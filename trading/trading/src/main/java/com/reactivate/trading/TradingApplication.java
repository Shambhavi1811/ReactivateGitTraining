package com.reactivate.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.reactivate.trading")
public class TradingApplication {

	public static void main(String[] args) {
		System.out.println("Starting Trading Application...");
		SpringApplication.run(TradingApplication.class, args);
	}

}
