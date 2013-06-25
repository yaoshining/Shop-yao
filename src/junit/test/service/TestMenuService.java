package junit.test.service;

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

import com.yao.backstage.model.po.Menu;
import com.yao.backstage.model.po.Notebook;
import com.yao.backstage.service.product.NotebookService;
import com.yao.backstage.service.system.MenuService;
import com.yao.backstage.service.system.ResourceService;
import com.yao.dao.bean.SearchOperator;
import com.yao.dao.bean.WhereCondition;

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
		Menu productMangeMenu = new Menu("产品管理");
		Menu subMenu1 = new Menu("产品管理子菜单1");
		com.yao.backstage.model.po.Resource addProduct = new com.yao.backstage.model.po.Resource(
				"product_add", "新建商品", "/html", "商品管理");
		resourceService.save(addProduct);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() { 
		List<WhereCondition> conditions = Arrays.asList(new WhereCondition[]{
				new WhereCondition("name", SearchOperator.EQUAL, "新建商品")
		});
		List<com.yao.backstage.model.po.Resource> resources = resourceService.find(com.yao.backstage.model.po.Resource.class, conditions , null);
		assert(resources.get(0).equals(resources.get(1)));
	}
	
}
