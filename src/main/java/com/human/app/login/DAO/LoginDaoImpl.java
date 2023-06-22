package com.human.app.login.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.app.login.model.LoginModel;

@Repository // DAO를 스프링에 인식시키기 위해서 사용
public class LoginDaoImpl implements LoginDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int selectMemberCnt(LoginModel model) {
		return sqlSession.selectOne("mappers.LoginMapper.selectMemberCnt", model);
//		return sqlSession.insert("mapper.MemberMapper.insertMember", model);
	}
}
