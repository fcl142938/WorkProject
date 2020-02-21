package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.accp.dao.ReimbursedetailMapper;
import com.accp.pojo.Reimbursedetail;

@Service
public class ReimbursedetailBiz {

	@Resource
	private ReimbursedetailMapper dao;

	/**
	 * 新增多条
	 * 
	 * @param list
	 * @return
	 */
	public int addReMoney(List<Reimbursedetail> list) {
		return dao.addReMoney(list);
	}

	/**
	 * 移除多个
	 * 
	 * @param list
	 * @return
	 */
	public int removeReMoney(List list) {
		return dao.removeReMoney(list);
	}

	/**
	 * 主键id查询多个
	 * 
	 * @param tbId
	 * @return
	 */
	public List<Reimbursedetail> queryByMid(String tbId) {
		return dao.queryByMid(tbId);
	}

	/**
	 * 根据主键id查询多个
	 * 
	 * @param list
	 * @return
	 */
	public List<Reimbursedetail> queryById(List list) {
		return dao.queryById(list);
	}

}
