package junit.test;

import java.util.Arrays;
import java.util.List;

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

import com.yao.test.Employee;
import com.yao.test.service.EmployeeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestDAO extends AbstractJUnit4SpringContextTests{
	
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
	public void testSave() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setName("测试");
		employeeService.save(employee);
	}
	
	@Test
	public void testFind() {
		employeeService.find(1);
	}
	
	@Test
	public void testBatchSave() {
		Employee employee1 = new Employee();
		employee1.setId(3);
		employee1.setName("测试");
		
		Employee employee2 = new Employee();
		employee2.setId(4);
		employee2.setName("测试");
		
		List<Employee> employeeList = Arrays.asList(new Employee[]{employee1,employee2});
//		dao.save(new Employee[]{employee1,employee2});
		employeeService.saveEntities(employee1,employee2);
	}
	
	@Test
	public void testDelete() {
		employeeService.removeById(3);
	}
	
	@Test
	public void testBatchDelete() {
		employeeService.removeByIds(1,2);
	}
	
	@Test
	public void testUpdate() {
		Employee emp = employeeService.find(1);
		emp.setName("修改");
		employeeService.update(emp);
	}
	
	@Test
	public void testBatchUpdate() {
		Employee emp1 = employeeService.find(1);
		emp1.setName("修改2");
		Employee emp2 = employeeService.find(2);
		emp2.setName("修改3");
		employeeService.updateEntities(new Employee[]{emp1,emp2});
	}
}
