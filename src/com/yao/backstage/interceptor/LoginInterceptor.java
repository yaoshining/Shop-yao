package com.yao.backstage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("User");
		if(user==null){
//			response.sendRedirect(request.getContextPath()+"/access/login/backstage");
			return true;
		}
		return super.preHandle(request, response, handler);
	}
}
