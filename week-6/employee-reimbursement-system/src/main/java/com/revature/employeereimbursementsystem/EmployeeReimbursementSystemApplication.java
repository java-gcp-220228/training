package com.revature.employeereimbursementsystem;

import com.revature.employeereimbursementsystem.model.ReimbursementStatus;
import com.revature.employeereimbursementsystem.model.ReimbursementType;
import com.revature.employeereimbursementsystem.model.UserRole;
import com.revature.employeereimbursementsystem.utility.DataPopulateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
// The above annotation implicitly adds the following annotations
// @Configuration
// @ComponentScan("com.revature.employeereimbursementsystem")
// @EnableAutoConfiguration // Tells Spring boot to automatically configure starter dependencies
@EnableTransactionManagement
public class EmployeeReimbursementSystemApplication {

	@Autowired
	private DataPopulateUtility util;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeReimbursementSystemApplication.class, args);
	}

	@Bean
	@Profile("default")
	public CommandLineRunner test() {
		return s -> {
			util.populateInitialData();
		};
	}

}
