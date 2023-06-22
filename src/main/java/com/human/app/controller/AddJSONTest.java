package com.human.app.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddJSONTest { //위의 예처럼 한 개 이상의 key-value들이 중괄호로 묶여진 구조를 객체(Object)라고 부른다.
	 public static void main(String[] args) throws JSONException {
	      JSONArray array = new JSONArray(); //array 라는 배열을 사용하여, 값을 담고.
	      array.put("JSON Array");
	      array.put("사용하여");
	      array.put("add하기");
	      array.put("추가");
	      array.remove(4);
	      JSONObject obj = new JSONObject(); // obj 라는 JSONObject를 사용하여, 배열화된 데이터를 하나의 객체로 담는다.
	      obj.put("결과는? :",array); // 객체 생성. "결과는? :"이 키값, array가 value.
	      //obj.remove("결과는? :"); //그래서 실제로 remove ("결과는? :") 을 삭제하면 삭제됨(키 값으로 삭제)
	      
	      System.out.println(obj); //Object를 사용하지 않으면 "결과는?" 라는 문구 조차 배열 데이터가 되기 때문
	      						   //JSONArray 안에는, String과, Object도 담을 수 있음.
	      System.out.println("");
	      
	      JSONObject jsonObj = new  JSONObject();
	      jsonObj.put("name", "유지윤");
	      jsonObj.put("age", 22);
	      jsonObj.put("tmi", "곧 23살 됨");
	      System.out.println("jsonObject: "+ jsonObj);
	 }
}
