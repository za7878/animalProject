package com.human.app.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	@Override
	// controller로 보내기 전에 처리하는 preHandel
	// 반환이 false라면 controller로 요청을 안함
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (logger.isDebugEnabled()) { // if(logger.isDebugEnabled())를 집어 넣어서 로그 레벨이 debug가 아니라면 아예 건너뛴다.
			logger.debug("====================================== START ======================================");
			logger.debug(" Request URI \t: " + request.getRequestURI()); // getRequestURI == 프로젝트+파일 경로를 가져온다.
		}

		HttpSession session = request.getSession();
		String loginid = null;

		if (session.getAttribute("loginid") != null) {
			loginid = (String) session.getAttribute("loginid");
		}

		// isBlank 는 inEmpty와 달리 공백을 빈값으로 처리한다.
		if (StringUtils.isBlank(loginid)) { // StringUtils 클래스만으로 거의 대부분의 문자열 처리를 수행.
			// 로그인 페이지로 이동
			logger.debug("로그인 페이지로 이동");
			// response.sendRedirect("url풀 경로");
			response.sendRedirect(request.getContextPath() + "/"); // getContextPath로 프로젝트 Path(길)만 가져온다. ex)
																	// http://localhost:8080/app/booking.jsp
			return false; // return "/app"; (URI는 프로젝트+ 파일경로. /app/booking.jsp) url은
							// 풀경로.(http://localhost:8080/app/booking.jsp)
		}

		logger.debug("여기까지!!");
		return super.preHandle(request, response, handler);
		// 상속받은 멤버와 자신의 멤버와 이름이 같을 때 super를 붙여서 구별
		// 조상 클래스에 선언된 멤버변수와 같은 이름의 멤버변수를 자손 클래스에서 중복해서 정의하는 것이 가능하기 때문
//    	return true;

	}

	@Override
	// postHandle() 메서드는 컨트롤러가 실행된 후에 호출
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("====================================== END ======================================");
		}
	}

}