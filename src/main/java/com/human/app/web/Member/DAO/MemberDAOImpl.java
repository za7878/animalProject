package com.human.app.web.Member.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.app.web.Member.Model.ParamListModel;

@Repository // DAO를 스프링에 인식시키기 위해서 사용
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession; // SqlSessionTemplate은 sqlSession 구현 코드를 대체하는 역할.

	/*
	 * private static final String GetTime = "MemberMapper.getTime"; private static
	 * final String InsertMember = "MemberMapper.insertMember"; private static final
	 * String SelectMember = "MemberMapper.selectMember";
	 * 
	 * @Override public String getTime() { return sqlSession.selectOne(GetTime);
	 * 
	 * }
	 * 
	 * @Override public void insertMember(MemberVO vo) {
	 * sqlSession.insert(InsertMember,vo); }
	 * 
	 * @Override public MemberVO selectMember(String userid) { return
	 * (MemberVO)sqlSession.selectOne(SelectMember,userid); }
	 * 
	 * 
	 */

	@Override
	public int selectMemberCount(ParamListModel paramList) {
		return sqlSession.selectOne("mapper.MemberMapper.selectMemberCount", paramList);

//		Map<String, String> param = new HashMap<String, String>(); // 2개 이상의 객체를 넘겨줄 땐, Map을 사용한다.
//		param.put("userId", paramList); //param.put 메소드를 사용하여 (key : value) 방식으로 데이터를 저장.
//		param.put("passCode", paramList);
//		return (Integer) sqlSession.selectOne("mapper.MemberMapper.selectMemberCount", param);
		
	}

//	@Override
//	public int insertMember(ParamListModel model) { // ParamList에 있는 parameter를 사용
//		return sqlSession.insert("mapper.MemberMapper.insertMember", model);
//	}

	@Override
//	public int insertMember(ParamListModel model) throws Exception 
	public int insertMember(ParamListModel model) {
		return sqlSession.insert("mapper.MemberMapper.insertMember", model);
	}
}
