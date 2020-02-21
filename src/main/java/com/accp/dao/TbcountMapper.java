package com.accp.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;

import com.accp.pojo.Tbcount;

public interface TbcountMapper {
   
	//查询单个
	Tbcount queryByUserAndMonth(@Param("year")int year,@Param("month")int month,@Param("userId")int userId);
	
	
	//根据条件查询多个集合
	 List<Tbcount> queryById(@Param("year")int year,@Param("month")Integer month,@Param("departmentId")int departmentId,@Param("status")Integer status);
	
	//添加 
	int addTb(Tbcount tbc);
	
	//修改  
	int modifyTb(Tbcount tbc);
	
	//条件查询  确定是否为部门
	List<Tbcount>  queryByMonth(@Param("startTime")int startTime,@Param("endTime")int endTime,@Param("year")Integer year,@Param("departmentId")Integer departmentId,@Param("status")Integer status);
}