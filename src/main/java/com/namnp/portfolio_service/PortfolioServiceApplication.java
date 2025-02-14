package com.namnp.portfolio_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class PortfolioServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioServiceApplication.class, args);
	}

}
