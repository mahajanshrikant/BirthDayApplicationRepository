package com.solution.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.solution.Test.model.Mail;
import com.solution.Test.service.MailService;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
	SpringApplication.run(TestApplication.class, args);

	}

}
