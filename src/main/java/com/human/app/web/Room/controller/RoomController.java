package com.human.app.web.Room.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.human.app.web.Room.Model.RoomInfoModel;
import com.human.app.web.Room.Service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

	@ResponseBody
	@RequestMapping(value="/getRoomList",method=RequestMethod.POST)
		public List<RoomInfoModel> getRoomList(Model model) {
			List<RoomInfoModel> roominfo = roomService.selectListRoom();
			return roominfo;
	}
	@ResponseBody //서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody 를 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할
	@RequestMapping(value="/deleteRoom",method=RequestMethod.POST)
		public int DeleteRoom(@ModelAttribute RoomInfoModel rInfo, Model model, HttpSession session) {
			int roomcode = rInfo.getRoomcode();
			model.addAttribute("roomcode",roomcode);
			return roomcode;
		}
		@RequestMapping(value="/addRoom",method=RequestMethod.POST)
		@ResponseBody
		public List<RoomInfoModel> addRoom(@ModelAttribute RoomInfoModel rInfo) {
			List<RoomInfoModel> roomInfo = roomService.AddRoom(rInfo);
			return roomInfo;
		}
		@RequestMapping(value="/UpDateRoom",method=RequestMethod.POST)
		@ResponseBody
		public List<RoomInfoModel> UpDateRoom(@ModelAttribute RoomInfoModel rInfo){
			List<RoomInfoModel> roominfo = roomService.UpDateRoom();
			return roominfo;
		}
}
