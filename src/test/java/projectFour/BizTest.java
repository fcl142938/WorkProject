package projectFour;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.biz.EmployeeBiz;
import com.accp.biz.ReimbursedetailBiz;
import com.accp.biz.TbreimburseBiz;
import com.accp.pojo.Employee;
import com.accp.pojo.Reimbursedetail;
import com.accp.pojo.Tbreimburse;

/**
 * biz 测试
 * 
 * @author ASUS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class BizTest {
	@Resource
	private EmployeeBiz eb;
	
	@Resource
	private TbreimburseBiz tb;
	
	@Resource
	private  ReimbursedetailBiz rb;
	
	@Test
	public void queryByLogin() {
		System.out.println(eb.queryByLogin("1001", "aaa12345"));
	}
	
	/**
	 *测试数据新增
	 */
	@Test
	public  void addTbreimburse() {
		Tbreimburse tbr= new Tbreimburse("123456", 2, 1013, new Date(), 1, 1000, "hhh", 6000.0, 0);
		List<Reimbursedetail>  list=new ArrayList<Reimbursedetail>();
		Reimbursedetail re= new Reimbursedetail("123456", 1.0, "12", "hj", "jjhj");
		list.add(re);
		//list.add(new Reimbursedetail("123456", 2.0, "12", "hj", "jjhj"));
		tbr.setList(list);
		System.out.println(tb.addTbreimburse(tbr));
	}
	
	/**
	 * 显示
	 */
	@Test
	public  void show() {
		System.out.println(tb.queryByTbId("1").getUserVo().getEmployeename());
		tb.queryByTbId("1").getTbList().forEach(temp->{
			System.out.println(temp.getCheckTime());
		});
	}
	
	/**
	 * 分页
	 */
	@Test
	public  void  TbPage() {
		 Employee em=new Employee();
		 em.setDepartmentid(1);
		 em.setPositionid(0);
		 em.setEmployeeid(1000);
		/*
		 * tb.queryPageByTerm(em,null, null, 1, null, null).getList().forEach(temp->{
		 * System.out.println(temp); });
		 */
	}
	
	/**
	 * 详表新增
	 */
	@Test
	public void reAdd() {
		List<Reimbursedetail> list= new ArrayList<Reimbursedetail>(0);
		list.add(new Reimbursedetail("123456", 2.0, "2", "3", "4"));
		list.add(new Reimbursedetail("123456", 2.0, "22", "32", "42"));
		list.add(new Reimbursedetail("123456", 2.0, "23", "33", "43"));
		System.out.println(rb.addReMoney(list));
	}
	
	/**
	 * 移除
	 */
	@Test
	public  void reRemove() {
		List list = new ArrayList();
		list.add(146);
		list.add(147);
		list.add(148);
		list.add(149);
		System.out.println(rb.removeReMoney(list));
	}
	
	
}
