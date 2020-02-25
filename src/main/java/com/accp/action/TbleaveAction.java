package com.accp.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.TbleaveBiz;
import com.accp.pojo.Employee;
import com.accp.pojo.Tbcheck;
import com.accp.pojo.Tbleave;
import com.accp.vo.TbleaveVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/leave")
public class TbleaveAction {
	
	@Resource
	private TbleaveBiz tb;
	
	/**
	 * 查询全部分页
	 * @return
	 */
	@GetMapping("query")
	public PageInfo<TbleaveVo> queryPage(HttpSession session,Integer currentPage,Integer pageSize,String startTime,String endTime) {
		Employee user =(Employee)session.getAttribute("user");
		if("".equals(startTime)) {
			startTime=null;
		}
		if("".equals(endTime)) {
			endTime=null;
		}
		
		return tb.queryByPage(user.getEmployeeid(), user.getPositionid(), user.getDepartmentid(), currentPage, startTime, endTime,pageSize);
	}
	
	/**
	 * 添加
	 * @param session
	 * @param tbleve
	 * @return
	 */
	@PostMapping("add")
	public  String addLeave(HttpSession session,Tbleave tbleve) {
		//System.out.println(tbleve.getStarttime());
		Employee user =(Employee)session.getAttribute("user");
		Integer number=tb.addTbLeave(tbleve,user);
		return number.toString();
	}
	
	/**
	 * 查看详情  返回页面初始化
	 * @param tbId
	 * @return
	 */
	@GetMapping("queryById")
	public Tbleave  queryById( Integer tbId) {
		//System.out.println(tb.queryById(tbId).getDepartmentName());
		return  tb.queryById(tbId);
	}
	
	@PostMapping("modifyStatus")
	public   String modifyStatus(HttpSession session,Integer tbId,Integer status,String event) {
		Employee user =(Employee)session.getAttribute("user");
		//System.out.println(user);
		Tbcheck tbs= new Tbcheck(tbId.toString(), 1, new Date(), user.getEmployeeid(), status, event);
		//System.out.println(tbs);
		Integer number =tb.modifyStatus(tbId, status,tbs);
		return number.toString();
	}
}
