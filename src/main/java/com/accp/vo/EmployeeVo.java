package com.accp.vo;

import com.accp.pojo.Employee;

public class EmployeeVo extends Employee {
	private String departmentName;
	private String positionName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}
