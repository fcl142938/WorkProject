package com.accp.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.accp.pojo.Reimbursedetail;

public class TbreimburseVo {
	//编号
	private String reimburseid;
	
	//创建人信息
	private EmployeeVo userVo;
	
	private String createManName;

	private Date createtime;


	private String nextName;

	private String event;

	private Double totalcount;

	private Integer statusid;
	
	private String statusName;
	
	//明细表
	private  List<Reimbursedetail>  reList= new ArrayList<Reimbursedetail>(0);
	
	private  List<TbcheckVo> tbList = new ArrayList<TbcheckVo>(0);
	

	public String getCreateManName() {
		return createManName;
	}

	public void setCreateManName(String createManName) {
		this.createManName = createManName;
	}

	public String getReimburseid() {
		return reimburseid;
	}

	public void setReimburseid(String reimburseid) {
		this.reimburseid = reimburseid;
	}

	public EmployeeVo getUserVo() {
		return userVo;
	}

	public void setUserVo(EmployeeVo userVo) {
		this.userVo = userVo;
	}

	public Date getCreatetime() {
		return createtime;
	}
	
	public  String getCreateTimeStr() {
		return new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(createtime);
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNextName() {
		return nextName;
	}

	public void setNextName(String nextName) {
		this.nextName = nextName;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
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

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Reimbursedetail> getReList() {
		return reList;
	}

	public void setReList(List<Reimbursedetail> reList) {
		this.reList = reList;
	}

	public List<TbcheckVo> getTbList() {
		return tbList;
	}

	public void setTbList(List<TbcheckVo> tbList) {
		this.tbList = tbList;
	}
	
	
	

}
