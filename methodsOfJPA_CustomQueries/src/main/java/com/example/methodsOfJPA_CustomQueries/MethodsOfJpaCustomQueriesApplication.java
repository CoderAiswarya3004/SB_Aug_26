package com.example.methodsOfJPA_CustomQueries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class MethodsOfJpaCustomQueriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaCustomQueriesApplication.class, args);
	}

	private Employee employee;

	@Bean 
	public CommandLineRunner commandLineRunner(){
		return args ->{
			Employee employee = Employee.builder()
			.employeeName("Ravi Sharma")
			.employeeDesignation("Manager")
			.employeeSalary(10000.98)
			.build();
		};
	}
}
