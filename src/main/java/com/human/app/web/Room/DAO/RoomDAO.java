package com.human.app.web.Room.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Model.RoomTypeModel;

public interface RoomDAO {

	List<RoomInfoModel> selectListRoom(); //RoomInfoModel을 List형태로 반환한다. 여러줄.
	
	List<RoomTypeModel> selectListRoomType();
	
	int DeleteRoom (int roomcode);
	
	List<RoomInfoModel> AddRoom(RoomInfoModel model);

	List<RoomInfoModel> UpDateRoom();
}