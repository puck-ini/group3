package com.group3.group3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Group3Application {

	public static void main(String[] args) {
		SpringApplication.run(Group3Application.class, args);
	}

}
