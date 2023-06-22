package com.human.app.controller;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;

public class ResponseEntityResponseExtractor<T> implements ResponseExtractor<String> {

	@Override
    public String extractData(ClientHttpResponse response) throws IOException {

        String result;

        if (response.getStatusCode() == HttpStatus.OK) {
            Scanner scanner = new java.util.Scanner(response.getBody()).useDelimiter("[\\(\\)]");
            scanner.next(); // callback name,
            String json = scanner.next();
            result = json;

        } else {
            result = null;
        }

        return result;
    }
	
}
