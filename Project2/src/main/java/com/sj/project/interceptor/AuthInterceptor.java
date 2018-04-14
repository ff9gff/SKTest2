package com.sj.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 스프링 인터셉터 클래스는 @어노테이션을 사용하지 않고
// HandlerInterceptorAdapter를 상속 받아서 만든다
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger= LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override // 컨트롤러 메소드 실행 전에 호출되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {		
		logger.info("preHandle() 호출!");
		
		// 세션에 로그인 정보가 있는지 확인
		HttpSession session = request.getSession();
		Object loginId = session.getAttribute("login_id");
		
		if (loginId == null) { // 로그인 하지 않은 경우
			logger.info("로그인 되어 있지 않음");
			
			// 처음 요청 주소를 저장
			saveDestination(request);

			// 로그인 화면으로 리다이렉트
			response.sendRedirect("../member/login"); 
			
			return false; // 컨트롤러 메소드를 실행하지 않음
			
		} else { // 로그인한 경우
			logger.info("로그인 아이디: " + loginId);
			return true; // 컨트롤러 메소드를 실행함
		}
	} // end preHandle(request, response, handler)
	
	private void saveDestination(HttpServletRequest request) {
		logger.info("saveDestination() 호출");
		// 요청 주소
		String uri = request.getRequestURI();
		logger.info("요청 주소: " + uri);
		
		// 쿼리 스트링 정보
		String query = request.getQueryString();
		logger.info("쿼리 스트링: " + query);
		
		if (query == null) {
			query = "";
		} else {
			query = "?" + query; // 이 메소드를 통해 나오는 쿼리스트링에는 앞 부분에 '?'가 없어서 직접 넣어준다
		}
		
		String dest = uri + query;
		logger.info("최종 요청 주소: " + dest);
		
		// 최종 요청 주소(dest)를 세션에 저장
		request.getSession().setAttribute("dest", dest);
	} // end saveDestination()
	
} // end class AuthInterceptor