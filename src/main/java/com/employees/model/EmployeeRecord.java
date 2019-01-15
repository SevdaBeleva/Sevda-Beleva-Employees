package com.employees.model;

import java.time.LocalDate;

public class EmployeeRecord {
	
	private Integer id;
	
	private Integer projectId;
	
	private LocalDate dateFrom;
	
	private LocalDate dateTo;
	
	@Override
    public boolean equals(Object o) {
        if (o != null && o instanceof EmployeeRecord) {
        	EmployeeRecord emp = (EmployeeRecord) o;
        	return this.id.equals(emp.id);
        } else {
        	return false;
        }
    }
	
	@Override
	public int hashCode() {		
		int hash = 7;
        hash = 31 * hash + (null == this.id ? 0 : this.id);
       
        return hash;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
	
}
