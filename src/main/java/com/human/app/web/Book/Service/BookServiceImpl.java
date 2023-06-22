package com.human.app.web.Book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.app.web.Book.DAO.BookDAO;
import com.human.app.web.Book.Model.BookedModel;
import com.human.app.web.Book.Model.GoBookingModel;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public void doAddBooking(int roomcode, int howmany, String checkin, String checkout, int total, String booker,
			String mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
//	public List<BookedModel> doFindBooked(DoBookingModel param) 
	public List<BookedModel> doFindBooked(BookedModel param) {
//		DoBookingModel param = new DoBookingModel();
//		param.setDay1(day);
//		param.setDay2(day1);
		
//		DoBookingModel param = new DoBookingModel(day, day1, null);
		
		List<BookedModel> findBook = bookDAO.doFindBooked(param);
		return findBook;
	}

	@Override
	public void doUpdateBooking(int bookcode, int howmany, String booker, String mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GoBookingModel> doPickBooking(GoBookingModel goBook) {
		List<GoBookingModel> PickListBooking = bookDAO.doPickBooking(goBook);
		return PickListBooking;
	}

	@Override
	public void doDeleteBooking(int bookcode) {
		// TODO Auto-generated method stub
		
	}

}
