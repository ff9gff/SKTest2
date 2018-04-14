package com.sj.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sj.project.domain.MemberVO;
import com.sj.project.service.MemberService;

// login-post 컨트롤러 메소드 실행 전/후에 동작할 인터셉터
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	private static final String SESSION_ATTR_ID = "login_id";
	private static final String SESSION_ATTR_MNO = "mno";
	private static final String SESSION_ATTR_AUTHORITY = "authority";
	private static final String SESSION_ATTR_NICKNAME = "login_nickname";
	
	@Autowired
	private MemberService memberservice;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandle(): 컨트롤러 메소드가 실행되기 전에 호출되는 메소드
		logger.info("preHandle() 호출!");

		// preHandle() 메소드의 리턴값:
		// true: 컨트롤러 메소드 호출!
		// false: 컨트롤러 메소드 호출되지 않음!

		// 세션에 기존 로그인 정보가 남아있으면 삭제
		// 그렇지 않으면 그냥 리턴
		// 세션 객체를 얻어옴
		HttpSession session = request.getSession();
		Object id = session.getAttribute(SESSION_ATTR_ID);

		if (id != null) { // 세션에 기존 정보가 남아 있는 경우
			session.removeAttribute(SESSION_ATTR_ID);
			logger.info("기존 로그인 정보 삭제 됨");
		} else { // 세션에 기존 정보가 없는 경우
			logger.info("기존 로그인 정보 없음");
		}

		return true;
	} // end preHandle()

	// 컨트롤러 메소드 수행 후, View가 완성되기 전에 호출되는 메소드
	// -> View(JSP)에 전달할 데이터, 세션 속성 등을 설정할 수 있음
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle() 호출!");

		// 로그인 정보를 세션에 저장하기 위해 request로부터 세션 객체를 불러옴
		HttpSession session = request.getSession();

		// Model 객체에 속성(attribute)를 설정하면
		// 인터셉터의 postHandle() 메소드의 ModelAndView 객체로 전달된다!

		// 컨트롤러에서 MemberVO 타입을 전달했기 때문에
		// ModelAndView에서 꺼낸 Attribute를 MemberVO로 형변환(casting)
		MemberVO result = (MemberVO) modelAndView.getModel().get("login_result");

		if (result != null) { // DB에 있는 아이디/패스워드 정보와 일치
			logger.info("새로운 로그인 성공");

			// 아이디 정보를 세션에 저장
			session.setAttribute(SESSION_ATTR_ID, result.getUserid());
			logger.info("Userid : " + result.getUserid());
			session.setAttribute(SESSION_ATTR_MNO, String.valueOf(result.getMno()));
			logger.info(String.valueOf("Mno : " + result.getMno()));
			session.setAttribute(SESSION_ATTR_AUTHORITY, String.valueOf(result.getAuthority()));
			logger.info(String.valueOf("Authority : " + result.getAuthority()));
			
			
			String nickname = memberservice.getNickname(result.getMno());			
			if(nickname != null){
				session.setAttribute(SESSION_ATTR_NICKNAME, nickname);
				logger.info("nickname : " + nickname);
			}			

			// 기존에 최종 요청 주소(dest)가 있는 경우는 해당 페이지로 이동
			Object dest = session.getAttribute("dest");
			if (dest != null) {
				response.sendRedirect((String) dest);
			} else {
				// 저장된 최종 요청 주소가 없는 경우는 메인 페이지로 이동
				response.sendRedirect("/project");
			}

		} else { // DB에 일치하는 회원 정보가 없는 경우
			// 세션에 저장하는 정보 없음
			logger.info("로그인 실패");
			response.sendRedirect("/project/member/login");
		} // end if (result != null)
		
	} // end postHandle()

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion() 호출!");
		super.afterCompletion(request, response, handler, ex);
	} // end afterCompletion()

} // end class LoginInterceptor