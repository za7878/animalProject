package com.human.app.web.Book.DAO;

import java.util.List;

import com.human.app.web.Book.Model.BookedModel;
import com.human.app.web.Book.Model.GoBookingModel;


public interface BookDAO {
	
			void doAddBooking(int roomcode, int howmany, String checkin, String checkout,
					
			int total, String booker, String mobile);
	
//			List<BookedModel> doFindBooked(DoBookingModel param);
			List<BookedModel> doFindBooked(BookedModel param);
			
			List<GoBookingModel> doPickBooking(GoBookingModel goBook);
			
			void doUpdateBooking(int bookcode, int howmany, String booker, String mobile);
	
			void doDeleteBooking(int bookcode);
			
			//ArrayList<doBooking> getBooking(String day1, String day2, String roomtype);
}