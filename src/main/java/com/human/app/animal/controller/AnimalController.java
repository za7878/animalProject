package com.human.app.animal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimalController {

	// private 다른 클래스가 로거를 가로챌 수 없도록
	// static 클래스당 하나의 로거 인스턴스만 있으므로 로거를 직렬화하려는 시도도 피할 수 있다.
	// final 클래스의 수명 동안 로거를 변경할 필요가 없다.
	private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
	// console창에 해당 로그를 사용하기 위해 선언.

//	@Autowired // Spring 에서 주입하려고자 하는 객체의 타입과 일치하는 객체를 자동으로 주입.

	@RequestMapping(value = "/") // <@RequestMapping> 특정 URL과 매칭되는 클래스나 메소드임을 명시
	public String home() {
		logger.debug("메인 페이지");
		// 가장 먼저 노출 되는 메인 페이지.
		// 해당 페이지에서 게시판 등의 다른 페이지 호출 가능.
		
		return "animal";
	}
}
