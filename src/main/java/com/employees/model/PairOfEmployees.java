package com.employees.model;

public class PairOfEmployees implements Comparable<PairOfEmployees>{
	
	private EmployeeRecord firstEmployee;
	
	private EmployeeRecord secondEmployee;
	
	private Integer projectId;

	private Long daysWorkedTogether;
	

	public EmployeeRecord getFirstEmployee() {
		return firstEmployee;
	}

	public void setFirstEmployee(EmployeeRecord firstEmployee) {
		this.firstEmployee = firstEmployee;
	}

	public EmployeeRecord getSecondEmployee() {
		return secondEmployee;
	}

	public void setSecondEmployee(EmployeeRecord secondEmployee) {
		this.secondEmployee = secondEmployee;
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Long getDaysWorkedTogether() {
		return daysWorkedTogether;
	}

	public void setDaysWorkedTogether(Long intervalPeriod) {
		this.daysWorkedTogether = intervalPeriod;
	}

	@Override
	public int compareTo(PairOfEmployees o) {			
		if(this.daysWorkedTogether > o.daysWorkedTogether) {
			return 1;
		} else if (this.daysWorkedTogether < o.daysWorkedTogether) {
			return -1;
		}
		return 0;		
	}
	
	@Override
    public boolean equals(Object o) {
        if (o != null && o instanceof PairOfEmployees) {
        	PairOfEmployees pair = (PairOfEmployees) o;
       
        	return (this.firstEmployee.getId().equals(pair.firstEmployee.getId())
        			|| this.secondEmployee.getId().equals(pair.secondEmployee.getId())
        			|| this.firstEmployee.getId().equals(pair.secondEmployee.getId())
        			|| this.secondEmployee.getId().equals(pair.firstEmployee.getId())
        			)
        			&& this.projectId.equals(pair.projectId);
        	
        } else {
        	return false;
        }
    }
	
	@Override
	public int hashCode() {		
		int hash = 7;
        hash = 31 * hash + (null == this.firstEmployee.getId() ? 0 : this.firstEmployee.getId());
        hash = hash + (null == this.secondEmployee.getId() ? 0 : this.secondEmployee.getId());
        hash = hash + (null == this.projectId ? 0 : this.projectId);
        
       
        return hash;
	}
	

}
