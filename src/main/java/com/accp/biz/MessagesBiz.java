package com.accp.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.accp.dao.MessagesMapper;
import com.accp.pojo.Messages;

@Service("MessagesBiz")
public class MessagesBiz {

		@Resource
		private MessagesMapper dao;
		
		// 添加
		public int addMe(Messages mess) {
			return dao.addMe(mess);
		}
		
		//修改转态
		public int modifyById(Integer id) {
			return dao.modifyById(id);
		}
		
		//查询
		public List<Messages> queryByUserId(Integer userid){
			return dao.queryByUserId(userid);
		}
		
}
