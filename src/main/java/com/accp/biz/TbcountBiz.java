package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.dao.TbcountMapper;
import com.accp.pojo.Tbcount;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("TbcountBiz")
public class TbcountBiz {
	
	@Resource
	private TbcountMapper dao;
	
	//条件呢分页查询
	public  PageInfo<Tbcount> queryAll(int startTime,int endTime,Integer year,Integer departmentId,Integer status,int curretPage,int  pageSize) {
		PageHelper.startPage(curretPage, pageSize);
		System.out.println(departmentId);
		return new PageInfo<Tbcount>(dao.queryByMonth(startTime, endTime, year, departmentId, status));
	}
	
	/**
	 * 根据条件查询统计
	 * @param year
	 * @param month
	 * @param departmentId
	 * @return
	 */
	public  List<Tbcount>  queryByTrime(Integer year,Integer month,Integer departmentId,Integer status){
		return dao.queryById(year, month, departmentId,status);
	}
}
