package com.human.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class MovieApiClient {

	private static final Logger logger = LoggerFactory.getLogger(MovieApiClient.class);

	private RestTemplate restTemplate = new RestTemplate();

	private String CLIENT_ID = "2J03kngrT2CYAlTdkxPu";
	private String CLIENT_SECRET = "JuMXxRLFE7";
	private static String OPENNAVERMOVIEURL_GETMOVIES = "https://openapi.naver.com/v1/search/movie.json?query={keyword}";

	public MoviesResponseModel requestMovie(String keyword) {
		final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
		headers.set("X-Naver-Client-Id", CLIENT_ID);
		headers.set("X-Naver-Client-Secret", CLIENT_SECRET);
//		headers.setContentType(MoviesResponseModel.Item); //New
//		headers.set("keyword", keyword);//New

		final HttpEntity<String> entity = new HttpEntity<>(headers);
//		URI uri=URI.create(OPENNAVERMOVIEURL_GETMOVIES); //New
		
//		ResponseEntity response =  restTemplate.exchange(uri, HttpMethod.GET, entity, MoviesResponseModel.class).getBody(); //New

		MoviesResponseModel test2 = null;
		try {

			test2 = restTemplate
					.exchange(OPENNAVERMOVIEURL_GETMOVIES, HttpMethod.GET, entity, MoviesResponseModel.class, keyword)
					.getBody();

			logger.debug("test2[{}]", test2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return test2;

	}

}
