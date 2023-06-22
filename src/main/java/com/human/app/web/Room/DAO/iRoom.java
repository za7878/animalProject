package com.human.app.web.Room.DAO;

import java.util.ArrayList;

import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Model.RoomTypeModel;

public interface iRoom {

	ArrayList<RoomInfoModel> getRoomList();
	ArrayList<RoomTypeModel> getRoomType();
	void doDeleteRoom(int roomcode);
	void doAddRoom(String roomname,int roomtype, int howmany, int howmuch);
	void doUpdateRoom(int roomcode,String roomname,int roomtype, int howmany, int howmuch);
}