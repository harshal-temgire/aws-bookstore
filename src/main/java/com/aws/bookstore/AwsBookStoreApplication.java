package com.aws.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.aws")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AwsBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsBookStoreApplication.class, args);
	}

}
