package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Department;

public interface DepartmentMapper {
   
	/**
	 * 查询
	 * @return
	 */
		List<Department>  queryAll(@Param("id")Integer id);
}