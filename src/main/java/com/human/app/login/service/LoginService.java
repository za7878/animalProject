package com.human.app.login.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.app.login.DAO.LoginDaoImpl;
import com.human.app.login.model.LoginModel;

@Service
public class LoginService {

	@Autowired LoginDaoImpl loginDaoImpl;
	
	public int selectMemberCnt(LoginModel model) {
		// 로그인 && 비밀번호 공백 확인 후 공백 아닐 시, 로그인 진행.
		if(StringUtils.isNotBlank(model.getUserid()) && StringUtils.isNotBlank(model.getUserpw())) {
			return loginDaoImpl.selectMemberCnt(model);
		} // 공백 일시, 0 반환.
		return 0;
	}
}
