package com.sedbproj.Railways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class RailwaysApplication {

	public static void main(String[] args) {

		SpringApplication.run(RailwaysApplication.class, args);
		System.out.println(org.hibernate.Version.getVersionString());
	}

}
