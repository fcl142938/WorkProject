package com.accp.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.TbstatusBiz;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/c/Tbstatus")
public class TbstatusAction {
	@Resource
	private TbstatusBiz tb;
	
	
	@PostMapping(value="queryAll",produces = "text/html; charset=utf-8")
	@ResponseBody
	public  String queryAll() {
		return JSON.toJSONString(tb.queryAll());
	}
}
