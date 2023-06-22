package com.human.app.web.Book.Service;

import java.util.List;

import com.human.app.web.Book.Model.BookedModel;
import com.human.app.web.Book.Model.GoBookingModel;


public interface BookService {

		public void doAddBooking(int roomcode, int howmany, String checkin, String checkout, int total, String booker, String mobile);

//		public List<BookedModel> doFindBooked(DoBookingModel param);
		public List<BookedModel> doFindBooked(BookedModel param);

		public void doUpdateBooking(int bookcode, int howmany, String booker, String mobile);
		
		public List<GoBookingModel> doPickBooking(GoBookingModel goBooking);
		
		public void doDeleteBooking(int bookcode);
	

}
