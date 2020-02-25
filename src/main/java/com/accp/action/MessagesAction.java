package com.accp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.MessagesBiz;
import com.accp.dao.MessagesMapper;
import com.accp.pojo.Messages;

@RestController
@RequestMapping("/api/mess")
public class MessagesAction {
		
	@Resource
	private MessagesBiz biz;
	
	//修改转态
	@GetMapping("modify")
	public int modifyById(Integer id) {
		return biz.modifyById(id);
	}
	
	//查询
	@GetMapping("query")
	public List<Messages> queryByUserId(Integer userid){
		return biz.queryByUserId(userid);
	}
	
	
}
