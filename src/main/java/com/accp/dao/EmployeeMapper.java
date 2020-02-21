package com.accp.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Employee;
import com.accp.vo.EmployeeVo;

/**
 * 用户表
 * @author ASUS
 *
 */
public interface EmployeeMapper {
	/**
	 * 删除
	 * @param employeeid
	 * @return
	 */
    int deleteByPrimaryKey(Integer employeeid);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(Employee record);

    /**
     * 查询
     * @param employeeid
     * @return
     */
    Employee selectByPrimaryKey(Integer employeeid);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Employee record);
    
    
    /**
     *登录
     * @param employeeName
     * @param password
     * @return
     */
    EmployeeVo queryByLogin(@Param("employeeId")String employeeId,@Param("password")String password);
    
    /**
     	* 查询下一个处理人
     * @param positionid
     * @param departmentid
     * @return
     */
    Employee  queryNextdealman(@Param("departmentid")Integer departmentid,@Param("positionid")Integer positionid);

}