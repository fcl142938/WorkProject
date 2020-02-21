package com.accp.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.dao.TbcheckMapper;
import com.accp.pojo.Tbcheck;

@Service("TbcheckBiz")
public class TbcheckBiz {
		
	
	@Resource
	private  TbcheckMapper dao;
	//新增
	public  int addTb(Tbcheck tb) {
		return dao.insertSelective(tb);
	}
}
