package com.accp.pojo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.accp.vo.TbcheckVo;
import com.alibaba.fastjson.annotation.JSONField;

public class Tbleave {
	private SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
	
	
    private Integer leaveid;

    private Integer typeid;

    private Integer createman;

    private Integer departmentid;
    
    private String imName;

    private Date createtime;
    
    private Integer createMan;
    
  
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date starttime;
    public  String getStarttimeStr() {
    	return df.format(starttime);
    }
    
   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;
    public  String getEndtimeStr() {
    	return df.format(endtime);
    }

    private Integer nextdealman;

    private String event;

    private Integer totalcount;

    private Integer statusid;
    
    private String statusName;
    
    private String departmentName;
    
    private List<TbcheckVo> list= new ArrayList<TbcheckVo>(0);
    
    

    public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getImName() {
		return imName;
	}

	public void setImName(String imName) {
		this.imName = imName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<TbcheckVo> getList() {
		return list;
	}

	public void setList(List<TbcheckVo> list) {
		this.list = list;
	}

	public Integer getLeaveid() {
        return leaveid;
    }

    public void setLeaveid(Integer leaveid) {
        this.leaveid = leaveid;
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

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

	public Integer getCreateMan() {
		return createMan;
	}

	public void setCreateMan(Integer createMan) {
		this.createMan = createMan;
	}
    
}