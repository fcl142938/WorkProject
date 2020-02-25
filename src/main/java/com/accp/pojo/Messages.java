package com.accp.pojo;

import java.util.Date;

public class Messages {
	//`id``userid``content``time``status`
	private Integer id;
	private Integer userid;
	private String content;
	private Date time;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Messages() {
		// TODO Auto-generated constructor stub
	}
	public Messages(Integer userid, String content, Date time) {
		super();
		this.userid = userid;
		this.content = content;
		this.time = time;
	}
	
	
	
}
