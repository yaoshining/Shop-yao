package com.yao.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
@WebServlet(loadOnStartup=1,urlPatterns="/initServlet")
public class InitServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3396697372041155894L;
	@Override
	public void init() throws ServletException {
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		EntityManagerFactory factory = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
		EntityManager em = factory.createEntityManager();
		InputStream in = getClass().getClassLoader().getResourceAsStream("import.sql");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			em.getTransaction().begin();
			for(String line="";(line=reader.readLine())!=null;) {
				em.createNativeQuery(line).executeUpdate();
			}
			em.getTransaction().commit();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
