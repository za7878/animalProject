//package com.human.app.controller;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.net.URL;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONObject;
//import org.springframework.aop.support.AopUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//public class PublicDataa {
//	/**
//	 * Servlet implementation class test
//	 */
//	@RequestMapping("/PublicData.do")
//	public class PublicData extends HttpServlet {
//	    private static final long serialVersionUID = 1L;
//	       
//	    /**
//	     * @see HttpServlet#HttpServlet()
//	     */
//	    public PublicData() {
//	        super();
//	        // TODO Auto-generated constructor stub
//	    }
//	 
//	    /**
//	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	     */
//	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        // TODO Auto-generated method stub
//	        request.setCharacterEncoding("utf-8");
//	        response.setContentType("text/html; charset=utf-8");
//	        
//	        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
//	        String serviceKey = "자신의 키값 입력";
//	        String parameter = "";
////	        serviceKey = URLEncoder.encode(serviceKey,"utf-8");
//	        PrintWriter out = response.getWriter();
//	        parameter = parameter + "&" + "areaCode=1";
//	        parameter = parameter + "&" + "eventStartDate=20170401";
//	        parameter = parameter + "&" + "eventEndDate=20171231";
//	        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
//	        parameter = parameter + "&" + "MobileOS=ETC";
//	        parameter = parameter + "&" + "MobileApp=aa";
//	        parameter = parameter + "&" + "_type=json";
//	        
//	        
//	        addr = addr + serviceKey + parameter;
//	        URL url = new URL(addr);
//	        
//	        InputStream in = url.openStream(); 
//	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
////	        IOUtils.copy(in, bos);
//	        in.close();
//	        bos.close();
//	        
////	        out.println(addr);
//	        
//	        String data = bos.toString();        
//	        out.println(data);
//	        
//	        JSONObject json = new JSONObject();
//	        json.put("data", data);
//	    }
//	 
//	    /**
//	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	     */
//	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        // TODO Auto-generated method stub
//	        request.setCharacterEncoding("utf-8");
//	        response.setContentType("text/html; charset=utf-8");
//	        
//	        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
//	        String serviceKey = "429e9l%2BRPBvvMYSqI0TIu0JgvFl1vio2dcUfXj7d66%2F%2B2glco1EDs1HDHJBssw9U7HAt1A11Cy6N0Hbk2INDfQ%3D%3D";
//	        String parameter = "";
////	        serviceKey = URLEncoder.encode(serviceKey,"utf-8");
//	        PrintWriter out = response.getWriter();
//	        parameter = parameter + "&" + "areaCode=1";
//	        parameter = parameter + "&" + "eventStartDate=20170401";
//	        parameter = parameter + "&" + "eventEndDate=20171231";
//	        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
//	        parameter = parameter + "&" + "MobileOS=ETC";
//	        parameter = parameter + "&" + "MobileApp=aa";
//	        parameter = parameter + "&" + "_type=json";
//	        
//	        
//	        addr = addr + serviceKey + parameter;
//	        URL url = new URL(addr);
//	        
//	        InputStream in = url.openStream(); 
//	        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
////	        AopUtils.copy(in, bos1);
//	        in.close();
//	        bos1.close();
//	        
////	        out.println(addr);
//	        
//	        String data = bos1.toString();        
//	        out.println(data);
//	        
//	        JSONObject json = new JSONObject();
//	        json.put("data", data);
//	    }
//	}
//}