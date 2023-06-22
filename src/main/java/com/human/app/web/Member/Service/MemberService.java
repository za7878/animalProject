package com.human.app.web.Member.Service;

import com.human.app.web.Member.Model.ParamListModel;


public interface MemberService {
//public static final MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
	
//	void selectCheckUser(ParamListModel model);
//	int selectMemberCount(String userId, String passCode);
	
//	int insertMember(ParamListModel model)throws Exception;
	int insertMember(ParamListModel model);
	
	int selectMemberCount(ParamListModel paramList);
}
