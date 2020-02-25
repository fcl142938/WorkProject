package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Messages;

public interface MessagesMapper {
	// 添加
	int addMe(Messages mess);
	
	//修改转态
	int modifyById(@Param("id")Integer id);
	
	//查询
	List<Messages> queryByUserId(@Param("userid")Integer userid);

}
