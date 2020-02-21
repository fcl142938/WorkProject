package com.accp.pojo;

public class Tbcount {
    private Integer countid;

    private Double money;

    private Integer year;

    private Integer month;

    private Integer departmentid;

    private Integer employeeid;

    private String departmentname;

    private String employeename;

    public Integer getCountid() {
        return countid;
    }

    public void setCountid(Integer countid) {
        this.countid = countid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }
    public Tbcount() {
		// TODO Auto-generated constructor stub
	}

	public Tbcount(Double double1, Integer year, Integer month, Integer departmentid, Integer employeeid,
			String departmentname, String employeename) {
		super();
		this.money =double1;
		this.year = year;
		this.month = month;
		this.departmentid = departmentid;
		this.employeeid = employeeid;
		this.departmentname = departmentname;
		this.employeename = employeename;
	}
    
}