package com.human.app.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONTest { // JSON 이란 데이터를 교환하는 문자 기반 형식
	public static void main(String args[]) {
//	      List<String> list = new ArrayList<String>();
//	      list.add("서울");
//	      list.add("제주");
//	      list.add("충남");
//	      JSONArray array = new JSONArray();
//	      for(int i = 0; i < list.size(); i++) {
//	         array.put(list.get(i));
//	      }
//	      JSONObject obj = new JSONObject();
//	      try {
//	         obj.put("Employee Names:", array);
//	      } catch(JSONException e) {
//	         e.printStackTrace();
//	      }
//	      System.out.println(obj.toString());
//		String jsonData = "{[{\"title\":\"극장판 <b>짱구</b>는 못말려: 격돌! 낙서왕국과 얼추 네 명의 용사들\","
//				+ "\"link\":\"https://movie.naver.com/movie/bi/mi/basic.nhn?code=205968\","
//				+ "\"image\":\"https://ssl.pstatic.net/imgmovie/mdi/mit110/2059/205968_P10_140031.jpg\","
//				+ "\"subtitle\":\"Crayon Shin-chan: Crash! Scribble Kingdom and Almost Four Heroes\","
//				+ "\"pubDate\":\"1970-01-01\","
//				+ "\"director\":\"쿄고쿠 타카히코|\","
//				+ "\"actor\":\"박영남|김환진|강희선|여민정|정유미|정혜옥|시영준|강새봄|\","
//				+ "\"userRating\":}]}";
//		try {
//			JSONParser jsonParse = new JSONParser();
//			// JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
//			JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
//			// JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다.
//			JSONArray personArray = (JSONArray) jsonObj.get("Persons");
//			for (int i = 0; i < personArray.length(); i++) {
//				System.out.println("======== person : " + i + " ========");
//				JSONObject personObject = (JSONObject) personArray.get(i);
//				System.out.println(personObject.get("title"));
//				System.out.println(personObject.get("link"));
//				System.out.println(personObject.get("image"));
//				System.out.println(personObject.get("subtitle"));
//			}
//			JSONArray booksArray = (JSONArray) jsonObj.get("Books");
//			for (int i = 0; i < booksArray.length(); i++) {
//				System.out.println("======== person : " + i + " ========");
//				JSONObject bookObject = (JSONObject) booksArray.get(i);
//				System.out.println(bookObject.get("pubDate"));
//				System.out.println(bookObject.get("director"));
//				System.out.println(bookObject.get("actor"));
//				System.out.println(bookObject.get("userRating"));
//			}
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		String jsonData = "{\"Persons\":[{\"name\":\"고경태\",\"age\":\"30\","
//				+ "\"블로그\":\"ktko.tistory.com\","
//				+ "\"gender\":\"남자\"}, "
//				+ "{\"name\":\"이홍준\","
//				+ "\"age\":\"31\","
//				+ "\"블로그\":\"없음\","
//				+ "\"gender\":\"남자\"}, "
//				+ "{\"name\":\"서정윤\","
//				+ "\"age\":\"30\","
//				+ "\"블로그\":\"없음\","
//				+ "\"gender\":\"여자\"}], "
//				+ "\"Books\":[{\"name\":\"javascript의모든것\","
//				+ "\"price\":\"10000\"},{\"name\":\"java의모든것\","
//				+ "\"price\":\"15000\"}]}"; 
//		try { JSONParser jsonParse = new JSONParser(); 
//		//JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다. 
//		JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData); 
//		//JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다. 
//		JSONArray personArray = (JSONArray) jsonObj.get("Persons");
//		for(int i=0; i < personArray.length(); i++) 
//		{ 
//			System.out.println("======== person : " + i + " ========"); 
//			JSONObject personObject = (JSONObject) personArray.get(i); 
//			System.out.println(personObject.get("name")); 
//			System.out.println(personObject.get("age")); 
//			} 
//		JSONArray booksArray = (JSONArray) jsonObj.get("Books"); 
//		for(int i=0; i < booksArray.length(); i++) { 
//			System.out.println("======== person : " + i + " ========"); 
//			JSONObject bookObject = (JSONObject) booksArray.get(i); 
//			System.out.println(bookObject.get("name")); 
//			System.out.println(bookObject.get("price")); 
//			} 
//		} catch (org.json.simple.parser.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
