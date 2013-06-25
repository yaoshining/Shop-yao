package junit.test.service;

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

import com.yao.backstage.service.system.MenuService;
import com.yao.backstage.service.system.ResourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestMenuService extends AbstractJUnit4SpringContextTests {
	@Resource 
	private MenuService menuService;
	@Resource 
	private ResourceService resourceService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		Menu productMangeMenu = new Menu("产品管理");
//		Menu subMenu1 = new Menu("产品管理子菜单1");
//		com.yao.backstage.model.po.Resource addProduct = new com.yao.backstage.model.po.Resource(
//				"product_add", "新建商品", "/html", "商品管理");
//		resourceService.save(addProduct);
		resourceService.removeById(com.yao.backstage.model.po.Resource.class, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() { 
//		List<WhereCondition> conditions = Arrays.asList(new WhereCondition[]{
//				new WhereCondition("name", SearchOperator.EQUAL, "新建商品")
//		});
//		List<com.yao.backstage.model.po.Resource> resources = resourceService.find(com.yao.backstage.model.po.Resource.class, conditions , null);
//		assert(resources.get(0).getId()==1);
		
	}
	
}
