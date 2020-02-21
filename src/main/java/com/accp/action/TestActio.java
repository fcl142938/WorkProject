package com.accp.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c/test")
public class TestActio {

	@GetMapping
	public String showPage()throws Exception{
		System.out.println("Handler被调用");
		return "/WEB-INF/view/errow.jsp";
	}
}
