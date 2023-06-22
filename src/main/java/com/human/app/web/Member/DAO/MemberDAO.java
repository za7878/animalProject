package com.human.app.web.Member.DAO;

import com.human.app.web.Member.Model.ParamListModel;


public interface MemberDAO {

//	int selectMemberCount(String userId);
	
	int insertMember(ParamListModel model);
	
//	int insertMember(ParamListModel model) throws Exception;

//	int selectMemberCount(String userId, String passCode);

	int selectMemberCount(ParamListModel paramList);

}