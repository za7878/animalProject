package com.human.app.web.Member.Service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.app.web.Member.DAO.MemberDAO;
import com.human.app.web.Member.Model.ParamListModel;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	MemberDAO memberDAO;

	@Override
	public int selectMemberCount(ParamListModel paramList) {
		int result = 0;
		// 아이디가 널이거나 공백이면 조회하지 않는다
		logger.debug("selectMemberCount_result[{}] ",result);
		
		if (StringUtils.isEmpty(paramList.getUserid())) {
			return result;
		}
		// if문에 해당하지 않는 조건이면 현 코드를 실행.
		// int result변수 값을 만들어, memberDAO의 selectMemberCount 안 userId를 꺼내어 result값에 넣는다.
		return memberDAO.selectMemberCount(paramList);
	}

	@Override
	public int insertMember(ParamListModel model) {
		return memberDAO.insertMember(model);
	}

//	@Override
//	public int insertMember(ParamListModel model) {
		
//		return memberDAO.insertMember(model);
//	}
//	int result = memberDAO.insertMember(model); //int 값을 만들어, interface에 insertMember Id를 가져와서 ParamListModel model 값에 담는다.
//	
//	return result; //result로 값을 리턴 해놓고, result = memberDAO.insertMember(model) 대신 memberDAO.isertMember(model)값을 리턴

	
//	@Transactional(rollbackFor = {Exception.class,RuntimeException.class}) //여러개의 예외 지정
	//rollbackFor를 사용하면 RuntimeException이 아니어도 롤백을 해준다.
	//@Transactional(noRollbackFor={IgnoreRollbackException.class} //롤백이 되지 않도록 지정하는 방법
//	@Transactional
//	@Override
//	public int insertMember(ParamListModel model) throws Exception{
//		memberDAO.insertMember(model);
		//Checked예외는 롤백이 되지 않는다
//		return memberDAO.insertMember(model);
//		throw  new RuntimeException("Exception for rollback"); //UnCheck Exception은 롤백을 해준다...
//		throw new IOException("Exception for rollback"); //롤백 해 주지 못해, 데이터를 db에 저장한다.
		//rollbackFor 옵션은, 롤백이 되는 클래스를 지정할 수 있다.
//	}

}