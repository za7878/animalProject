//package com.human.app.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.FlashMap;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import com.human.app.web.Book.Model.DoBookingModel;
//import com.human.app.web.Member.Model.ParamListModel;
//import com.human.app.web.Member.Service.MemberService;
//import com.human.app.web.Pet.Model.PetModel;
//import com.human.app.web.Pet.Service.PetService;
//import com.human.app.web.Room.Model.RoomTypeModel;
//import com.human.app.web.Room.Service.RoomService;
//
//@Controller // 컨트롤러임을 알려주는 Annotation
//public class HomeController {
//
//	// private 다른 클래스가 로거를 가로챌 수 없도록
//	// static 클래스당 하나의 로거 인스턴스만 있으므로 로거를 직렬화하려는 시도도 피할 수 있다.
//	// final 클래스의 수명 동안 로거를 변경할 필요가 없다.
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	// console창에 해당 로그를 사용하기 위해 선언.
//
//	@Autowired // Spring 에서 주입하려고자 하는 객체의 타입과 일치하는 객체를 자동으로 주입.
//	private MemberService memberService; // 인터페이스를 사용하여 유연성을 가짐
//
//	@Autowired
//	private MoviesService moviesService;
//	
//	@Autowired
//	private PetService petService;
//	
//	@Autowired
//	private RoomService roomService;
//
//	@RequestMapping(value = "/") // <@RequestMapping> 특정 URL과 매칭되는 클래스나 메소드임을 명시
//	public String home(HttpServletRequest request, Model model) {
//		//	FlashMap에 값을 저장한다.
//		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
//		if (flashMap != null) {
//			model.addAttribute("message", flashMap.get("message"));
//		}
//		logger.debug("hello iam login");
//
//		return "home";
//	}
//
//	@RequestMapping("/login")
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("mav", "던질 오브젝트가 없는데..");
//		mav.setViewName("login");
//		return mav;
//	}
//	
//	@RequestMapping("/movie")
//	public String movie() {
//		return "movie";
//	}
//	
//	@RequestMapping(value="/movie/{keyword}", method = RequestMethod.GET)
//	@ResponseBody
//	public MoviesResponseModel searchMovie(@PathVariable String keyword) { //@PathVariable로 keyword 값을 전달 받는다.
//		logger.debug("keyword:[{}]",keyword);
//		return moviesService.findByKeyword(keyword);
//	}
////	@RequestMapping(value="/movie/{keyword}", method = RequestMethod.GET,  produces = "application/json; charset=utf8")
////	@ResponseBody
////	public MoviesResponseModel searchMovie(@PathVariable String keyword, Map<String, Object> param) { //@PathVariable로 keyword 값을 전달 받는다.
////		Gson gson = new Gson();
////		
////		JsonParser jparser = new JsonParser();
////		
////		 JsonElement elementKey = jparser.parse(param.get(keyword).toString());
////		 List <String> keyList = gson.fromJson(elementKey, (new TypeToken<List<String>>() {  }).getType());
////		logger.debug("keyword:[{}]",keyword);
////		return moviesService.findByKeyword(keyword);
////	}
//	
//	@RequestMapping(value="nealo", method=RequestMethod.GET)
//	public String loginGET() {
//		
//		return "nealo";
//	}
//	
//	@RequestMapping(value="loginPostNaver", method=RequestMethod.POST)
//	public String loginPOSTNaver(HttpSession session) {
//		
//		return "loginPostNaver";
//	}
//	@RequestMapping(value="callBack",method=RequestMethod.GET)
//	public String callBack( ) {
//		
//		
////		
////		String clientId = "DfQRvYEkM9ZTauBcYVHE";//애플리케이션 클라이언트 아이디값";
////	    String clientSecret = "XbAkYUCDa4";//애플리케이션 클라이언트 시크릿값";
////	    String code = request.getParameter("code");
////	    String state = request.getParameter("state");
////	    String redirectURI = URLEncoder.encode("http://localhost:8080/app/callBack", "UTF-8");
////	    String apiURL;
////	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
////	    apiURL += "client_id=" + clientId;
////	    apiURL += "&client_secret=" + clientSecret;
////	    apiURL += "&redirect_uri=" + redirectURI;
////	    apiURL += "&code=" + code;
////	    apiURL += "&state=" + state;
////	    String access_token = "";
////	    String refresh_token = "";
////	    System.out.println("apiURL="+apiURL);
////	    try {
////	      URL url = new URL(apiURL);
////	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
////	      con.setRequestMethod("POST");
////	      int responseCode = con.getResponseCode();
////	      BufferedReader br;
////	      System.out.print("responseCode="+responseCode);
////	      if(responseCode==200) { // 정상 호출
////	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
////	      } else {  // 에러 발생
////	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
////	      }
////	      String inputLine;
////	      StringBuffer res = new StringBuffer();
////	      while ((inputLine = br.readLine()) != null) {
////	        res.append(inputLine);
////	      }
////	      br.close();
////	      if(responseCode==200) {
////	        out.println(res.toString());
////	      }
////	    } catch (Exception e) {
////	      System.out.println(e);
////	    }
//		
//		
//		
//		
//		return "callBack";
//	}
//	
//	
//	@RequestMapping("/pet")
//	public String pet(@ModelAttribute PetModel param, HttpSession session, Model model) {
//		List<PetModel> petList = petService.Animal(param);
//		
//		if(petList != null && petList.size() > 0) {
//			for(PetModel p: petList) {
//				logger.debug("pets[{}] ",p.getPetName());
//			}
//		}
//		model.addAttribute("petList", petList);
//		return "peta";
//	}
//
//	@RequestMapping("/newbie")
//	public String donewbie() {
//
//		return "newbie";
//	}
//
//	@RequestMapping("/viewinfo")
//	public String goviewinfo(@ModelAttribute ParamListModel param, Model model) {
//		model.addAttribute("login", "login");
//		model.addAttribute("password", "password");
//		model.addAttribute("testaaa", "jiyoon babo");
//		return "viewinfo";
//	}
//
//	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
//	public String checkUser(HttpSession session, @ModelAttribute ParamListModel paramList, HttpServletRequest request,
//			Model model) {
//
//		FlashMap fm = RequestContextUtils.getOutputFlashMap(request);
//
//		int n = memberService.selectMemberCount(paramList);
//		String message = "로그인에 실패했습니다.";
//		logger.debug("paramList[{}]", paramList);
//
//		if (n > 0) {
//			session.setAttribute("loginid", paramList.getUserid());
//			fm.put("message", "로그인에 성공했습니다.");
//			return "redirect:/booking";
//		} else {
//			model.addAttribute("message", message);
//			return "home";
//		}
//		// redirect를 해주지 않으면, 기존 입력했던
//		// 값이 틀린 값일 시, 그 값을 forward로 인해 공유하고 있음.
//	}
//
//	@RequestMapping(value = "/booking", method = RequestMethod.GET)
//	public String booking(HttpSession session, @ModelAttribute ParamListModel param, Model model) {
////		String loginid = (String) session.getAttribute("loginid");
////		if (loginid == null) {
////			session.setAttribute("message","로그인 후 진행해주세요.");
////			return "redirect:/";
////		}
//			return "booking";
//		}
//
//	@RequestMapping("/room")
//	public String room(@ModelAttribute DoBookingModel doBo, HttpSession session, Model model) {
//		List<RoomTypeModel> roomtype = roomService.selectListRoomType();
//		model.addAttribute("roomtypeList", roomtype);
//		return "room";
//	}
//
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate(); //session에 들은 정보를 무효화.
//		return "home";
//	}
//
//	@RequestMapping(value = "/signin", method = RequestMethod.POST)
//	public String signin(HttpServletRequest request, HttpSession session, HttpServletResponse response,
//			@ModelAttribute ParamListModel signin, Model model) throws Exception {
//		// 1. 기존에 회원가입 한 사람인지 체크 DB조회 - 같은 아이디 가입x
////		signin.setPasscode1(null);
//		int count = memberService.selectMemberCount(signin);
//
//		// 2_1. 회원가입 한 사람이 아니면 회원가입 진행
//		if (count == 0) {// 중복회원 0 == 회원가입 진행
//			int regCount = memberService.insertMember(signin);// insert
//
//			if (regCount > 0) {
//				// 등록 성공
//				session.setAttribute("message", "가입에 성공했습니다, 로그인 페이지로 이동합니다"); // 메세지
//				return "redirect:/";
//			}
//		}
//		// 2_2. 회원가입이 된 사람일 시, 기존 회원유저 임을 알려줌.
////			model.addAttribute("message", "기존에 가입된 회원입니다.");
//		session.setAttribute("message", "기존에 가입된 회원입니다.");
//		return "redirect:/newbie";
//		// home URL 보낸 후 클라이언트에서 새로운 요청을 생성, home에게 재요청.
//		// 최초의 Request와 Response 객체 유효X, 재생성O.
//		// 사용이유 : 가입처리 시에 응답페이지 (signin)에서,
//		// 새로고침을 누른다고 하더라도 처음의 요청 정보는 존재 하지 않으므로
//		// 연속적인 처리를 방지 할 수 있음.
//		// 시스템에 변화가 생기는 요청의 경우에는 redirect 사용한다. (회원가입, 글쓰기 등)
//	}
//	
//}