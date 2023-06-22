package com.human.app.web.Room.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.human.app.web.Room.DAO.RoomDAO;
import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Model.RoomTypeModel;

@Service //service 패키지는 DB에 접근하는 코드는 repository에 위임하고, 비즈니스 로직과 관련된 모든 코드가 모여있다.
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDAO roomDAO;

	@Override
	public List<RoomInfoModel> selectListRoom() {
		List<RoomInfoModel> SelectRoomlist = roomDAO.selectListRoom();
		return SelectRoomlist;
	}

	@Override
	public List<RoomTypeModel> selectListRoomType() {
		
		// 로직
		
		List<RoomTypeModel> roomTypeList = roomDAO.selectListRoomType();
		return roomTypeList;
	}

	@Override
	public int DeleteRoom(int roomcode) {
//		int result = roomDAO.DeleteRoom(roomcode);
		return roomDAO.DeleteRoom(roomcode);
	}

	@Override
	public List<RoomInfoModel> AddRoom(RoomInfoModel model) {
		return roomDAO.AddRoom(model);
	}

	@Override
	public List<RoomInfoModel> UpDateRoom() {
		List<RoomInfoModel> UpDateRoom = roomDAO.UpDateRoom();
		return UpDateRoom;
	}
}