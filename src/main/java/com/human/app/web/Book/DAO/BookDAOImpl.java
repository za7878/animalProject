package com.human.app.web.Book.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.app.web.Book.Model.BookedModel;
import com.human.app.web.Book.Model.GoBookingModel;

@Repository
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void doAddBooking(int roomcode, int howmany, String checkin, String checkout, int total, String booker,
			String mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
//	public List<BookedModel> doFindBooked(DoBookingModel param) 
	public List<BookedModel> doFindBooked(BookedModel param) {
//		List<GoBookingModel> doPick = (List<GoBookingModel>) sqlSession.selectMap("mapper.BookMapper.doFindBooked", day1, day1);
//		List<GoBookingModel> doPick = sqlSession.selectOne("mapper.BookMapper".doFindBooked, day);
		return sqlSession.selectList("mapper.BookMapper.doFindBooked", param);
	}

	@Override
	public List<GoBookingModel> doPickBooking(GoBookingModel goBook) {
		List<GoBookingModel> PickListBooking = sqlSession.selectList("mapper.BookMapper.doPickBooking", goBook);
		return PickListBooking;
	}

	@Override
	public void doUpdateBooking(int bookcode, int howmany, String booker, String mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDeleteBooking(int bookcode) {
		// TODO Auto-generated method stub
		
	}

}
