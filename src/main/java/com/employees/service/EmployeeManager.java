package com.employees.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.employees.model.EmployeeRecord;
import com.employees.model.PairOfEmployees;

public interface EmployeeManager {
	
	/**
	 * Groups people that have worked within one project.
	 * <br>
	 * Use hash map to store the result.
	 * <br>
	 * Key - project id.
	 * <br>
	 * Value - list of grouped employees.
	 * <br>
		
	 * @param list
	 * @return emplyeeslistGrouped 
	 */
	public Map<Object, List<EmployeeRecord>> groupEmployees(List<EmployeeRecord> list);
	
	/**
	 * Find each combination of employee's pair within one project.
	 * <br>
	 * Store pairs in descending tree set.
	 * <br>
     * Set - no duplications.
     * <br>
     * Descending tree set - sorted set in descending way.
		
	 * @param emplyeeslistGrouped
	 * @return pairs
	 */
	public Set<PairOfEmployees> findEmployeePairs(Map<Object, List<EmployeeRecord>> emplyeeslistGrouped); 
	
	public void printEmployeesGroupedByProject(Map<Object, List<EmployeeRecord>> emplyeeslistGrouped);
	
	public void printPairsOfEmployees(Set<PairOfEmployees> pairs); 

}
