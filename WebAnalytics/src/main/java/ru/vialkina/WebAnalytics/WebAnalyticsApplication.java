package ru.vialkina.WebAnalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages = {"ru.vialkina.WebAnalytics"})
@SpringBootApplication()
@EnableAutoConfiguration
//@EnableCaching
@EnableScheduling
@ComponentScan(basePackages = "ru.vialkina.WebAnalytics.repository")
@EntityScan(basePackages = {"ru.vialkina.WebAnalytics.model"})
public class WebAnalyticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAnalyticsApplication.class, args);
	}

}