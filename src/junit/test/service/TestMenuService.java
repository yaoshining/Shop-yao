package junit.test.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import com.yao.backstage.service.system.MenuService;
import com.yao.backstage.service.system.ResourcesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestMenuService extends AbstractJUnit4SpringContextTests {
	@Resource
	private MenuService menuService;
	@Resource
	private ResourcesService resourcesService;
	
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
		resourcesService.removeById(com.yao.backstage.model.po.Resources.class, 1);
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
	@Test
	public void testAdd() { 
		Menu m =new Menu();   //因为menu是新建的,所以有多少子菜单,和有多少资源,也需要我们指定,默认肯定是null
		//这里开始定义这个菜单的子菜单,你可以看下po里面children是啥类型,是Set<Menu>类型,所以从语法上我们也应该set一个Set类的对象进去啊
		//从语义上来说,一个菜单的子菜单肯定不只一个,java里用来表示多个对象的类,要么是数组,要么是集合,再怎么也不能set一个字符串进去啊
		Set<Menu> children = new HashSet<Menu>(Arrays.asList(new Menu[]{
				new Menu(),    //这里每一个都是一个菜单对象,也就是子菜单
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu()
		}));
		m.setChildren(children);  //这里我们把子菜单的集合set进去
		m.setName("修改商品");  
		Menu parentMenu = new Menu();
		//parentMenu的get,set.......
		m.setParent(parentMenu);  //这里从语法上来说要set进po里定义的parent类型的对象,看下po,parent是Menu类型的把
		//从语义上来说,我们要设置当前菜单的父菜单,肯定也是个菜单了
		Set<com.yao.backstage.model.po.Resources> children1 = 
				new HashSet<com.yao.backstage.model.po.Resources>(Arrays.asList(new com.yao.backstage.model.po.Resources[]{
				new com.yao.backstage.model.po.Resources(),    //这里每一个都是一个菜单对象,也就是子菜单
				new com.yao.backstage.model.po.Resources()
		}));
		m.setResources(children1);  //同样资源和子菜单一个道理,不过一般情况下,在定义菜单的时候这些资源必须已经存在了,因为现有资源,才能定义菜单下有哪些资源
		menuService.save(m);
	}	
	@Test
	public void testDelete() { 
		resourcesService.removeById(com.yao.backstage.model.po.Resources.class, 1); 
	}	
	
	@Test
	public void testUpdate() { 
		com.yao.backstage.model.po.Resources rs=new com.yao.backstage.model.po.Resources();
		resourcesService.save(rs);
		rs.setCode("asdsadad"); 
		Set<Menu> menus = new HashSet<Menu>(Arrays.asList(new Menu[]{
				new Menu(),
				new Menu(),
				new Menu(),
				new Menu()
		}));
		rs.setMenus(menus);
		rs.setModule("module");
		rs.setName("name");
		rs.setUrl("url");
		resourcesService.update(rs); 
	}	
}