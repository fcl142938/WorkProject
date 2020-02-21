package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Tbleave;
import com.accp.vo.TbleaveVo;

public interface TbleaveMapper {

	// 删除
	int deleteByPrimaryKey(@Param("leaveid") Integer leaveid);

	// 新增
	int insert(Tbleave record);

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	List<TbleaveVo> queryByPage(@Param("userid")Integer userid,@Param("positionId")Integer positionId,@Param("departmentId")Integer departmentId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	/**
	 * 通过id查询
	 * @param tbId
	 * @return
	 */
	Tbleave queryById(@Param("tbId")Integer tbId);
	
	/**
	 * 修改状态
	 * @param tbId
	 * @param status
	 * @param nextMan
	 * @return
	 */
	int  modidyStatus(@Param("tbId")Integer tbId,@Param("status")Integer status,@Param("nextMan")Integer nextMan);

}