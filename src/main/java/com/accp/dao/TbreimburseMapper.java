package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Tbreimburse;
import com.accp.vo.TbreimburseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 报销
 * 
 * @author ASUS
 *
 */
public interface TbreimburseMapper {

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Tbreimburse record);

	/**
	 * 新增两张表
	 * 
	 * @param tbreimburse
	 * @return
	 */
	int addTbreimburse(Tbreimburse tbreimburse);

	/**
	 * 查询单个
	 * 
	 * @param tbId
	 * @return
	 */
	TbreimburseVo queryByTbId(@Param("tbId") String tbId);
	
	/***
	 * 条件分页查询
	 * @param StartTime
	 * @param endTime
	 * @param statusId
	 * @return
	 */
	List<TbreimburseVo> queryPageByTerm(@Param("departmentid")Integer departmentid,@Param("userid")Integer userid, @Param("StartTime") String StartTime, @Param("endTime")String endTime,@Param("statusId")Integer statusId,@Param("positionId")Integer positionId,@Param("showId")Integer showId);
	
	/**
	 * 删除两个页面
	 * @param tbId
	 * @return
	 */
	int removeById(String tbId);
	
	//查询单个数据
	Tbreimburse queryByID(@Param("tbId")String tbid);
}