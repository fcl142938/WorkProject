package com.accp.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.dao.EmployeeMapper;
import com.accp.vo.EmployeeVo;

@Service("EmployeeBiz")
public class EmployeeBiz {
	
	@Resource
	private EmployeeMapper dao;
	
	
	public  EmployeeVo  queryByLogin(String employeeId,String password) {
		return dao.queryByLogin(employeeId, password);
	}
}
