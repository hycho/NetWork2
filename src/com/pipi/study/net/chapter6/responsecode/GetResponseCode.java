package com.pipi.study.net.chapter6.responsecode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetResponseCode {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://naver.com");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		System.out.println("response code = " + conn.getResponseCode());	//�����ڵ带 ���������� ����
		System.out.println("response message = " + conn.getResponseMessage());	//����޼����� ����
	}

}
