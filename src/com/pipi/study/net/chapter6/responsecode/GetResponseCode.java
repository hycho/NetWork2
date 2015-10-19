package com.pipi.study.net.chapter6.responsecode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetResponseCode {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://naver.com");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		System.out.println("response code = " + conn.getResponseCode());	//응답코드를 정수형으로 제공
		System.out.println("response message = " + conn.getResponseMessage());	//응답메세지를 제공
	}

}
