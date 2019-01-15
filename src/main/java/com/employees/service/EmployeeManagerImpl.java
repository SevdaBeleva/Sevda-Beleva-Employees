package com.employees.service;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.employees.model.EmployeeRecord;
import com.employees.model.PairOfEmployees;

public class EmployeeManagerImpl implements EmployeeManager {
	
	//Find each combination of employee's pair within one project,
	// checking if working days overlap or not.
	@Override
	public Set<PairOfEmployees> findEmployeePairs(Map<Object, List<EmployeeRecord>> emplyeeslistGrouped) {	
		Set<PairOfEmployees> pairs = new TreeSet<>(Collections.reverseOrder());
		
		for(Map.Entry<Object, List<EmployeeRecord>> entry : emplyeeslistGrouped.entrySet()) {
			for(int i = 0; i < entry.getValue().size(); i++) {
				for(int j = i; j < entry.getValue().size(); j++) {
					if(!entry.getValue().get(i).equals(entry.getValue().get(j))) {						
						EmployeeRecord firstEmployee = entry.getValue().get(i);
						EmployeeRecord secondEmployee = entry.getValue().get(j);
						boolean datesOverlap = checkIfDatesOverlap(firstEmployee, secondEmployee);
						if(datesOverlap) {
							PairOfEmployees pair = new PairOfEmployees();
							pair.setFirstEmployee(firstEmployee);
							pair.setSecondEmployee(secondEmployee);
							pair.setProjectId((Integer)entry.getKey());
							pair.setDaysWorkedTogether(calculateDaysdTogetherOfPair(pair));
							pairs.add(pair);
						}
					}
				}
			}
		}
		
		return pairs;
	}
	
	//group employees by project id
	@Override
	public Map<Object, List<EmployeeRecord>> groupEmployees(List<EmployeeRecord> list) {
		Map<Object, List<EmployeeRecord>> emplyeeslistGrouped = new HashMap<>();
		
		if(list != null) {
			emplyeeslistGrouped = list.stream().collect(Collectors.groupingBy(w -> w.getProjectId()));				
		}
		
		return emplyeeslistGrouped;
	}
	
	public void printEmployeesGroupedByProject(Map<Object, List<EmployeeRecord>> emplyeeslistGrouped) {
		if(emplyeeslistGrouped != null) {
			System.out.println("------------------------------------------------------");
			System.out.println("EMPLOYESS GROUPED BY PROJECT ID");
			System.out.println("------------------------------------------------------");
			
			for(Map.Entry<Object, List<EmployeeRecord>> entry :  emplyeeslistGrouped.entrySet()) {
				System.out.print("Project id:" + entry.getKey() + " Employee IDs:");			
				for(int i = 0; i < entry.getValue().size(); i++){
					System.out.print(entry.getValue().get(i).getId() + ", ");
				}
				System.out.println();
			}
			
			System.out.println();
		}			
	}
	
	@Override
	public void printPairsOfEmployees(Set<PairOfEmployees> pairs) {
		if(pairs != null) {
			System.out.println("------------------------------------------------------");
			System.out.println("PAIRS OF EMPLOYESS");
			System.out.println("------------------------------------------------------");
			
			for(PairOfEmployees pair : pairs) {
				System.out.println("Employee ID:" + pair.getFirstEmployee().getId()
						+ " Employee ID:" + pair.getSecondEmployee().getId() 
						+ " Project ID:" + pair.getProjectId() 
						+ " Days worked:" + pair.getDaysWorkedTogether());
			}
			System.out.println();
		}		
	}
	
	private long calculateDaysdTogetherOfPair(PairOfEmployees pair){		
		long daysWorkedTogether = 0;
		
		if(pair != null) {
			EmployeeRecord emp1 = pair.getFirstEmployee();
			EmployeeRecord emp2 = pair.getSecondEmployee();
			LocalDate beginDate1 = emp1.getDateFrom();
			LocalDate endDate1 = emp1.getDateTo();
			LocalDate beginDate2 = emp2.getDateFrom();
			LocalDate endDate2 = emp2.getDateTo();
			
			LocalDate begin = null;
			LocalDate end = null;
			
			if(beginDate1.isAfter(beginDate2) || beginDate1.isEqual(beginDate2)) {
				begin = beginDate1;
			} else {
				begin = beginDate2;
			}
			
			if(endDate1.isBefore(endDate2) || endDate1.isEqual(endDate2)) {
				end = endDate1;
			} else {
				end = endDate2;
			}
			
			daysWorkedTogether = DAYS.between(begin, end);
		}
		
		return daysWorkedTogether;
	}
	
	private boolean checkIfDatesOverlap(EmployeeRecord firstEmployee, EmployeeRecord secondEmployee) {
		if((firstEmployee.getDateFrom().isBefore(secondEmployee.getDateTo()) || firstEmployee.getDateFrom().isEqual(secondEmployee.getDateTo()))		
			&& 
			(firstEmployee.getDateTo().isAfter(secondEmployee.getDateFrom()) || firstEmployee.getDateTo().isEqual(secondEmployee.getDateFrom()))) {
			return true;		
		}
		
		return false;
		
	}
	
}
