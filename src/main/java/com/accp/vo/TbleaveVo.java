package com.accp.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TbleaveVo {
		private  Integer leaveId;
		private String leaveName;
		@JSONField(format = "yyyy-MM-dd HH:mm:ss")
		private Date createTime;
		private String nextName;
		private String statusName;
		@JSONField(format = "yyyy-MM-dd HH:mm:ss")
		private Date checkTime;
		private String resultName;
		public Integer getLeaveId() {
			return leaveId;
		}
		public void setLeaveId(Integer leaveId) {
			this.leaveId = leaveId;
		}
		public String getLeaveName() {
			return leaveName;
		}
		public void setLeaveName(String leaveName) {
			this.leaveName = leaveName;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getNextName() {
			return nextName;
		}
		public void setNextName(String nextName) {
			this.nextName = nextName;
		}
		public String getStatusName() {
			return statusName;
		}
		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
		public Date getCheckTime() {
			return checkTime;
		}
		public void setCheckTime(Date checkTime) {
			this.checkTime = checkTime;
		}
		public String getResultName() {
			return resultName;
		}
		public void setResultName(String resultName) {
			this.resultName = resultName;
		}
		
}
