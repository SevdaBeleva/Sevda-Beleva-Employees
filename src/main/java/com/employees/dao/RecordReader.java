package com.employees.dao;

import java.util.List;

import com.employees.model.EmployeeRecord;


public interface RecordReader {
	
	/**
	 * Opens text file.
	 * <br>
	 * Reads each row and create and an object from it.
	 * <br>
	 * Store objects in a list.
	 * 
	 * @param fileName
	 * @return EmployeeRecord
	 */
	List<EmployeeRecord> readRowsFromFile(String fileName); 

}
