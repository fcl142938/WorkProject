package projectFour;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-web.xml"})
@WebAppConfiguration
public class ActionTest {


	@Autowired
	private WebApplicationContext wac;// 非常重要

	private MockMvc mockMvc;// mvc_handler测试对象

	@Before
	public void initMockMvc() {
		// 构建者模式
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}


	@Test
	public void testPersonActionList() throws Exception {
		//模拟get请求
		/*
		 * MvcResult
		 * rs=mockMvc.perform(get("/c/flightinfo/query?flightId=1")).andExpect(status().
		 * isOk()).andDo(print()).andReturn(); Flightinfo fig
		 * =(Flightinfo)rs.getModelAndView().getModel().get("PAGE_INFO");
		 * System.out.println(fig);
		 */
	}

}
