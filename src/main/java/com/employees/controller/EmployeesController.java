package com.employees.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employees.dao.RecordReader;
import com.employees.model.EmployeeRecord;
import com.employees.model.PairOfEmployees;
import com.employees.service.EmployeeManager;


@Controller
public class EmployeesController {
	
	private static final String FILENAME = "input.txt";
	
	@Autowired
	private RecordReader recordReader;
	
	@Autowired
	private EmployeeManager employeeManager;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {		
		//read each row from the file and store employee's data
		List<EmployeeRecord> list = recordReader.readRowsFromFile(FILENAME);
		
		//find all people that have worked in the same project
		Map<Object, List<EmployeeRecord>> emplyeeslistGrouped = employeeManager.groupEmployees(list);
		
		//find pairs within the project e.g. if their working days overlap or not.
		Set<PairOfEmployees> pairs = employeeManager.findEmployeePairs(emplyeeslistGrouped);
		
		model.addAttribute("pairs", pairs);
		
		//print the result on the console
		employeeManager.printEmployeesGroupedByProject(emplyeeslistGrouped);
		employeeManager.printPairsOfEmployees(pairs);			

		return "index";
	}
	
}
