package com.employees.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.employees.dao.RecordReader;
import com.employees.model.EmployeeRecord;


public class EmployeeRecordReader implements RecordReader {

	@Override
	public List<EmployeeRecord> readRowsFromFile(String fileName) {
		List<EmployeeRecord> list = new ArrayList<>();					
		BufferedReader br = null;
		FileReader fr = null;
		
		URL url = getClass().getResource(fileName);
		File file = new File(url.getPath());
		
		try {
			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(file);
			br = new BufferedReader(fr);
	
			String currentLine;
	
			while((currentLine = br.readLine()) != null) {
				String[] tokens = currentLine.split(",");
				EmployeeRecord emp = new EmployeeRecord();
				emp.setId(Integer.valueOf(tokens[0].trim()));
				emp.setProjectId(Integer.valueOf(tokens[1].trim()));
				emp.setDateFrom(LocalDate.parse(tokens[2].trim()));
				
				if(tokens[3].toLowerCase().trim().equals("null")) {
					emp.setDateTo(LocalDate.now());
				} else {
					emp.setDateTo(LocalDate.parse(tokens[3].trim()));
				}
				
				list.add(emp);
				
				System.out.println(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}		
		return list;
	}
		
}
