package com.namnp.gold_service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class GoldServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldServiceApplication.class, args);

//        try {
//			Document doc = Jsoup.connect("https://giavang.org/trong-nuoc/doji/").get();
//			System.out.println(doc);
//
//		} catch (IOException e) {
//            throw new RuntimeException(e);
//        }

	}

}
