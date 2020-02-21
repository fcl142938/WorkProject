package com.accp.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.EmployeeBiz;
import com.accp.pojo.Employee;
import com.accp.vo.EmployeeVo;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/c/Employee")
public class EmployeeAction {
	
	@Resource
	private EmployeeBiz eb;
	
	@PostMapping("login")
	public  Object login(HttpSession session,String employeeId,String password) {
		EmployeeVo ev=eb.queryByLogin(employeeId, password);		
		if(ev==null){
			return "no";
		}else {
			session.setAttribute("user", ev);
			return JSON.toJSONString(ev);
		}
	}
	
	@PostMapping("extis")
	public  String extis(HttpSession session) {
		
		/*
		 * Employee user =(Employee)session.getAttribute("user");
		 * System.out.println(user.getPassword());
		 */
		 
		session.removeAttribute("user");
		return "";
	}
}
