package com.accp.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TbcheckVo {

	private Integer checkId;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date checkTime;

	private String checkManName;
	private String resultName;
	private String checkComment;

	public Integer getCheckId() {
		return checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public String getCheckTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkTime);
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckManName() {
		return checkManName;
	}

	public void setCheckManName(String checkManName) {
		this.checkManName = checkManName;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getCheckComment() {
		return checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

}
