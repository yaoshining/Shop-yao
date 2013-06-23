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

import com.yao.test.po.Notebook;
import com.yao.test.po.OperatingSystem;
import com.yao.test.service.NotebookService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestNotebookService extends AbstractJUnit4SpringContextTests{
	@Resource   //让spring注入这个service,下面才能用
	private NotebookService notebookService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {  //先别看那个,看了你就晕了,你先在这写保存的测试,后面有说明,要新建个实体报讯啊,notebook Service最好只对notebook操作
		Notebook nb=new Notebook();
		//保存到数据库啊
//		nb.setBrand("联想");  //这时po里brand的值就是联想了啊
//		nb.setColour("红");
//		nb.setModelNumber("y480");   //不写都是null
//		nb.setOperatingSystem(OperatingSystem.Windows7);  //因为都可以是空,并且id也是自增长的,所以都不写,也会把NULL插入数据库
		notebookService.save(nb); //忘记步骤了..你现在新建的po里有数据吗,你要保存的是po里的数据啊,当你保存的时候,hibernate就会按注解定义的规则,把brand的值映射到数据库里brand字段里
	}
	
	@Test
	public void testUpdate() {  //这写个修改
		Notebook nb=new Notebook();
		notebookService.save(nb); //修改肯定要现有数据了,这就已经有了,id自增长为1,其他都是null,然后修改,肯定要先查出来了
		Notebook notebook = notebookService.find(1);   //先查啊....查要按ID查吧,给哥ID就行了么,你看说明啊
		//现在查到的notebook就是数据库里的一条记录,上面save进去的么,id1,别的为null,你把他的值改了
		notebook.setBrand("联想修改"); 
		notebook.setColour("黑");  //这就已经该了么
		notebookService.update(notebook);   //这就更新到数据库了,行了,知道怎么用就可以了,恩
	}
	
	@Test
	public void testDelete(){
		notebookService.removeById(1);  //行了,这些你会用就行,关键是有的时候增删改查做不了,得自己写逻辑
	}
	
	@Test
	public void testMyMethod(){
		notebookService.test();
	}
	
	
	

}
