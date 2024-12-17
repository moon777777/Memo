package com.bbar.memo.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		// /post/list-view
		String uri = request.getRequestURI();
		// Integer 쓰는 이유 이렇게 하면 있는지 없는지 활용 못함 int가 null을 저장 못함 그래서 null을 저장 가능한 Wrapper class로
		// 로그인이 안된 상태에서 메모와 관련된 기능 페이지의 접근을 막는다
		// 로그인 페이지로 이동
		
		if(userId == null) {
			// /post로 시작하는 url path 확인
			if(uri.startsWith("/post")) {
				
				// 로그인 페이지로 리다이렉트 정보를 response에 담는다.
				response.sendRedirect("/user/login-view");
				return false;
			}
		} else {
			// 로그인이 되어 있는 경우 사용자와 관련된 페이지 접근을 막는다
			// 메모 리스트 페이로 이동
			// /user 로 시작하는 url path 확인
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/list-view");
				return false;
			}
		}
 
	return true;
	}
}
