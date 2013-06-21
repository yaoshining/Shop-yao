package com.yao.test;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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
	}
}
