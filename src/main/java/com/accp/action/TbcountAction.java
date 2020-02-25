package com.accp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.TbcountBiz;
import com.accp.pojo.Employee;
import com.accp.pojo.Tbcount;
import com.accp.util.ExPortExcelAction;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/count")
public class TbcountAction {
	
	@Resource
	private  TbcountBiz tb;
	
	/**
	 * 条件查询
	 * @param session
	 * @param startTime
	 * @param endTime
	 * @param year
	 * @param status
	 * @param curretPage
	 * @return
	 */
	@GetMapping("queryAll")
	public  PageInfo<Tbcount>  queryAll(HttpSession session,Integer startTime,Integer endTime,Integer year,Integer status,Integer curretPage,Integer pageSize){
		Employee user =(Employee)session.getAttribute("user");
		Integer departmentid=null;
		if(user.getPositionid()==1) {
			departmentid =user.getDepartmentid();   
		}
		return tb.queryAll(startTime, endTime, year, departmentid, status, curretPage, pageSize); 
	}
	
	
	/**
	 * 查询单个详情
	 * @param year
	 * @param month
	 * @param departmentId
	 * @return
	 */
	@GetMapping("queryOne")
	public  List<Tbcount> queryByTrime(int year, Integer month,int departmentId,Integer status){
		System.out.println(month);
		return tb.queryByTrime(year, month, departmentId,status);
	}
	
	@PostMapping("educeExcel")
	public Map<String,String>  educeExcel(Integer year, Integer month,Integer departmentId,Integer status,String oftype){
		ExPortExcelAction exExcel= new ExPortExcelAction(year,month,departmentId,status,oftype,tb.queryByTrime(year, month, departmentId, status));
		exExcel.reprotExcel();
		Map<String, String> map= new HashMap<String, String>();
		map.put("status", "ok");
		return map;
	}
	
	
}
