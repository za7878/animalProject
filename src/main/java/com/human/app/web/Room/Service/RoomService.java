package com.human.app.web.Room.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Model.RoomTypeModel;


public interface RoomService {
	List<RoomInfoModel> AddRoom(RoomInfoModel model);
	
	List<RoomInfoModel> selectListRoom();

	List<RoomTypeModel> selectListRoomType();
	
	List<RoomInfoModel> UpDateRoom();
	
	int DeleteRoom (int roomcode);
}
