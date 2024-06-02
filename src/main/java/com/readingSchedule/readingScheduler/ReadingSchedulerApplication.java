package com.readingSchedule.readingScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.readingSchedule.readingScheduler"})
@EnableWebMvc
public class ReadingSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingSchedulerApplication.class, args);
	}

}
