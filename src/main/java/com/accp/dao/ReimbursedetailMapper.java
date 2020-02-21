package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Reimbursedetail;

public interface ReimbursedetailMapper {

	/**
	 * 新增多个
	 * @param record
	 * @return
	 */
    int addReMoney(@Param("list")List<Reimbursedetail> list);
    
    /**
     * 移除多个
     * @param list
     * @return
     */
    int removeReMoney(@Param("list")List list);
    
    /**
     * 删除主表时查询删除图片
     * @return
     */
    List<Reimbursedetail> queryByMid(@Param("tbId")String tbId);
    
    /**
     * 根据主键id查询多个
     * @param list
     * @return
     */
    List<Reimbursedetail> queryById(@Param("list")List list);
    
}