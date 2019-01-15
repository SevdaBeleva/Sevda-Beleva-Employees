package com.employees.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.employees.dao.EmployeeRecordReader;
import com.employees.dao.RecordReader;
import com.employees.service.EmployeeManager;
import com.employees.service.EmployeeManagerImpl;

@Configuration
public class AppConfig {
	
	@Bean
	@Lazy
	@Scope("prototype")
	public RecordReader recordReader() {
		return new EmployeeRecordReader();
	}

	@Bean
	@Lazy
	@Scope("prototype")
	public EmployeeManager employeeManager() {
		return new EmployeeManagerImpl();
	}
	
}
