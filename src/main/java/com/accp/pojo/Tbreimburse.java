package com.accp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tbreimburse {
    private String reimburseid;

    private Integer typeid;

    private Integer createman;

    private Date createtime;

    private Integer departmentid;

    private Integer nextdealman;

    private String event;

    private Double totalcount;

    private Integer statusid;
    
    private List<Reimbursedetail> list= new ArrayList<Reimbursedetail>(0);
    

    public List<Reimbursedetail> getList() {
		return list;
	}

	public void setList(List<Reimbursedetail> list) {
		this.list = list;
	}

	public String getReimburseid() {
        return reimburseid;
    }

    public void setReimburseid(String reimburseid) {
        this.reimburseid = reimburseid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getCreateman() {
        return createman;
    }

    public void setCreateman(Integer createman) {
        this.createman = createman;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getNextdealman() {
        return nextdealman;
    }

    public void setNextdealman(Integer nextdealman) {
        this.nextdealman = nextdealman;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public Double getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Double totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

	public Tbreimburse(String reimburseid, Integer typeid, Integer createman, Date createtime, Integer departmentid,
			Integer nextdealman, String event, Double totalcount, Integer statusid) {
		super();
		this.reimburseid = reimburseid;
		this.typeid = typeid;
		this.createman = createman;
		this.createtime = createtime;
		this.departmentid = departmentid;
		this.nextdealman = nextdealman;
		this.event = event;
		this.totalcount = totalcount;
		this.statusid = statusid;
	}
    public Tbreimburse() {
		// TODO Auto-generated constructor stub
	}
   
}