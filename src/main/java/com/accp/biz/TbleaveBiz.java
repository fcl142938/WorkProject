package com.accp.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.accp.dao.EmployeeMapper;
import com.accp.dao.TbcheckMapper;
import com.accp.dao.TbleaveMapper;
import com.accp.pojo.Employee;
import com.accp.pojo.Tbcheck;
import com.accp.pojo.Tbleave;
import com.accp.vo.TbleaveVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 请假
 * @author ASUS
 *
 */
@Service("TbleaveBiz ")
public class TbleaveBiz {
		
	@Resource
	private TbleaveMapper dao;
	
	@Resource
	private  EmployeeMapper ebdao;
	
	@Resource
	private TbcheckMapper chedao;
	
	/**
	 * 新增
	 * @param tbleve
	 * @return
	 */
	public int addTbLeave(Tbleave tbleve,Employee user) {
		tbleve.setCreateman(user.getEmployeeid());
		tbleve.setCreatetime(new Date());
		tbleve.setDepartmentid(user.getDepartmentid());
		tbleve.setStatusid(2);
		//处理下一个处理人
		//普通员工
		if(user.getPositionid()==2) {
			tbleve.setNextdealman(ebdao.queryNextdealman(user.getDepartmentid(),1).getEmployeeid());
		}else {
			tbleve.setNextdealman(1000);
		}
		return dao.insert(tbleve);
	}
	
	/**
	 * 删除两张数据
	 * @param leaveid
	 * @return
	 */
	public  int removeById(Integer leaveid) {
		return dao.deleteByPrimaryKey(leaveid);
	}
	
	/**
	 *分页查询
	 * @param userid
	 * @param positionId
	 * @param departmentId
	 * @param currentPage
	 * @return
	 */
	public  PageInfo<TbleaveVo> queryByPage(Integer userid,Integer positionId,Integer departmentId,Integer currentPage,String startTime,String endTime,Integer pageSize){
		PageHelper.startPage(currentPage,pageSize);
		if(positionId==2||positionId==3||positionId==5) {
			positionId=null;
		}
		
		if(positionId!=null&&positionId!=1) {
			departmentId=null;
		}
		return new PageInfo<TbleaveVo>(dao.queryByPage(userid, positionId, departmentId,startTime,endTime));
	}
	
	/**
	 * 查询单个
	 * @param tbId
	 * @return
	 */
	public Tbleave queryById(Integer tbId) {
		return dao.queryById(tbId);
	}
	
	/**
	 * 审核
	 * @param tbId
	 * @param status
	 * @return
	 */
	public  int  modifyStatus(Integer tbId,Integer status,Tbcheck tbche) {
		//新增审核信息
		chedao.insertSelective(tbche);
		//审核状态
		if(status==1) {
			//存档
			if(dao.queryById(tbId).getNextdealman()==1017) {
				return dao.modidyStatus(tbId, 7, 10000);
			}else {
				return dao.modidyStatus(tbId, 4, 1017);
			}
		}else {
			return dao.modidyStatus(tbId, 8, 10000);
		}
		
	}
}
