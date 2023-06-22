package com.human.app.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.app.login.model.LoginModel;
import com.human.app.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET) // <@RequestMapping> 특정 URL과 매칭되는 클래스나 메소드임을 명시
	public String login(@ModelAttribute LoginModel model) {
		logger.debug("로그인 페이지");

		// 기존에 존재하는 회원일 시, 로그인 성공 후에 main 페이지로 이동.
		int result = loginService.selectMemberCnt(model);
		if (0 < result) {
			return "animal";
		} // 실패 시, 로그인 창 refresh.
		return "login";
	}
}
