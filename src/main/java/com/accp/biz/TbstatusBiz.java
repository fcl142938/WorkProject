package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accp.dao.TbstatusMapper;
import com.accp.pojo.Tbstatus;

@Service("TbstatusBiz")
public class TbstatusBiz {
	
	@Resource
	private TbstatusMapper dao;
	
	public  List<Tbstatus>  queryAll(){
		return dao.queryAll();
	}
}
