package com.human.app.web.Room.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Model.RoomTypeModel;
			//DB 접근과 관련된 문제가 발생하면 repository 부분을 확인
@Repository //DAO를 스프링에 인식시키기 위해서 사용
public class RoomDAOImpl implements RoomDAO {
	
	@Autowired
    private SqlSessionTemplate sqlSession; //SqlSessionTemplate은 sqlSession 구현 코드를 대체하는 역할.

	@Override
	public List<RoomInfoModel> selectListRoom() {
		return sqlSession.selectList("mapper.RoomMapper.selectListRoom");
	}

	@Override
	public List<RoomTypeModel> selectListRoomType() {
		List<RoomTypeModel> roomTypeList = sqlSession.selectList("mapper.RoomMapper.selectListRoomType");
		return roomTypeList;
	}

	@Override
	public int DeleteRoom(int roomcode) {
		int result = sqlSession.delete("mapper.RoomMapper.DeleteRoom");
		return result;
	}

	@Override
	public List<RoomInfoModel> AddRoom(RoomInfoModel model) {
//		List<RoomInfoModel> AddRoomList = sqlSession.insert(AddRoomList);
		return (List<RoomInfoModel>) model;
	}

	@Override
	public List<RoomInfoModel> UpDateRoom() {
		return null;
	}	
}
