package com.human.app.web.Book.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.human.app.web.Book.Model.BookedModel;
import com.human.app.web.Book.Model.GoBookingModel;
import com.human.app.web.Book.Service.BookService;
import com.human.app.web.Book.Service.BookServiceImpl;

@Controller
public class BookingController {

	private SqlSession sqlSession;

	@Autowired
	BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	@ResponseBody
	public List<BookedModel> addBooking(@ModelAttribute BookedModel booked) {
		List<BookedModel> addBook = addBooking(booked);
		return addBook;
	}

	
	@RequestMapping(value = "/findBooked", method = RequestMethod.POST)
	public View findBooked(@ModelAttribute BookedModel param, ModelMap model) {
	List<BookedModel> arBooked = bookService.doFindBooked(param);
	
	model.addAttribute("arBooked", arBooked);
	
	return new MappingJacksonJsonView();
	}

	@RequestMapping(value = "/goBooking", method = RequestMethod.POST)
	@ResponseBody
	public List<GoBookingModel> pickBooking(@ModelAttribute GoBookingModel goBook) {
		List<GoBookingModel> arBooking = bookService.doPickBooking(goBook);
		return arBooking;
	}

	@RequestMapping(value = "/updateBooking", method = RequestMethod.POST)
	@ResponseBody
	public String updateBooking(HttpServletRequest hsr) {
		BookServiceImpl book = sqlSession.getMapper(BookServiceImpl.class);
		book.doUpdateBooking(Integer.parseInt(hsr.getParameter("bookcode")),
				Integer.parseInt(hsr.getParameter("howmany")), hsr.getParameter("booker"), hsr.getParameter("mobile"));
		return "ok";
	}

	@RequestMapping(value = "/deleteBooking", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBooking(HttpServletRequest hsr) {
		int bookcode = Integer.parseInt(hsr.getParameter("bookcode"));
		BookServiceImpl book = sqlSession.getMapper(BookServiceImpl.class);
		book.doDeleteBooking(bookcode);
		return "ok";
	}
}
