package com.accp.pojo;

import java.util.Date;

public class Tbcheck {
    private Integer checkid;

    private String bizid;

    private Integer typeid;

    private Date checktime;

    private Integer checkman;

    private Integer checkresult;

    private String checkcomment;

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Integer getCheckman() {
        return checkman;
    }

    public void setCheckman(Integer checkman) {
        this.checkman = checkman;
    }

    public Integer getCheckresult() {
        return checkresult;
    }

    public void setCheckresult(Integer checkresult) {
        this.checkresult = checkresult;
    }

    public String getCheckcomment() {
        return checkcomment;
    }

    public void setCheckcomment(String checkcomment) {
        this.checkcomment = checkcomment == null ? null : checkcomment.trim();
    }
    public Tbcheck() {
		// TODO Auto-generated constructor stub
	}

	public Tbcheck(String bizid, Integer typeid, Date checktime, Integer checkman, Integer checkresult,
			String checkcomment) {
		super();
		this.bizid = bizid;
		this.typeid = typeid;
		this.checktime = checktime;
		this.checkman = checkman;
		this.checkresult = checkresult;
		this.checkcomment = checkcomment ;
	}
    
}