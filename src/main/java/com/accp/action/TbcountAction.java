package com.accp.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.TbcountBiz;
import com.accp.pojo.Employee;
import com.accp.pojo.Tbcount;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/api/count")
public class TbcountAction {
	
	@Resource
	private  TbcountBiz tb;
	
	/**
	 * 条件查询
	 * @param session
	 * @param startTime
	 * @param endTime
	 * @param year
	 * @param status
	 * @param curretPage
	 * @return
	 */
	@GetMapping("queryAll")
	@ResponseBody
	public  PageInfo<Tbcount>  queryAll(HttpSession session,int startTime,int endTime,Integer year,Integer status,Integer curretPage){
		Employee user =(Employee)session.getAttribute("user");
		Integer departmentid=null;
		if(user.getPositionid()==1) {
			departmentid =user.getDepartmentid();   
		}
		return tb.queryAll(startTime, endTime, year, departmentid, status, curretPage, 5); 
	}
	
	
	/**
	 * 查询单个详情
	 * @param year
	 * @param month
	 * @param departmentId
	 * @return
	 */
	@GetMapping("queryOne")
	public  String queryByTrime(Model model,int year, Integer month,int departmentId,String view,Integer status){
		List<Tbcount> list= tb.queryByTrime(year, month, departmentId,status);
		model.addAttribute("List", list);
		model.addAttribute("data",JSON.toJSONString(list) );
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("departmentId",departmentId);
		return "/ui/"+view+".jsp";
	}
	
	
}
