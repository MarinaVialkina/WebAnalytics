package ru.vialkina.WebAnalytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableAutoConfiguration
@EnableCaching
@EnableScheduling
@ComponentScan(basePackages = "ru.vialkina.WebAnalytics.repository")
@EntityScan(basePackages = {"ru.vialkina.WebAnalytics.model"})
public class WebAnalyticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAnalyticsApplication.class, args);
	}

}