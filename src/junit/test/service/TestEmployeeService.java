package junit.test.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yao.dao.bean.Order;
import com.yao.dao.bean.SearchOperator;
import com.yao.dao.bean.WhereCondition;
import com.yao.test.Employee;
import com.yao.test.service.EmployeeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestEmployeeService extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private EmployeeService employeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("测试");
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("测试");
		
		employeeService.saveEntities(employee1,employee2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<WhereCondition> conditions = Arrays.asList(new WhereCondition[]{
				new WhereCondition("name", SearchOperator.IN, new String[]{"测试","测试2"})
		});
		Map<String, Order> orderby = new HashMap<String, Order>();
		orderby.put("id", Order.DESC);
		List<Employee> resultList = employeeService.find(Employee.class,conditions,orderby);
		System.out.println(resultList.size());
	}

}
