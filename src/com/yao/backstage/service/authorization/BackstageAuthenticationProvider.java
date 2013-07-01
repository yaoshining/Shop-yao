package com.yao.backstage.service.authorization;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class BackstageAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
