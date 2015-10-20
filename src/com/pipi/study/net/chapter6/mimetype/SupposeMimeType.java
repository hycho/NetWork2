package com.pipi.study.net.chapter6.mimetype;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SupposeMimeType {

	public static void main(String[] args) {
		/**
		 * guessContentTypeFromName(String name) : name의 확장자 부분을 기반으로 객체의 컨텐츠 타입을 추측하고 반환한다..
		 * guessContentTypeFromStream(InputStream is) : stream의 몇개의 시작 바이트를 읽고 타입을 식별한다. guessContentTypeFromName보다 신뢰하기 어려우며 예를 들어 XML파일 위에 XML이 아닌 주석값을 놓았을 경우 HTML파일로 잘못 분류를 할 수 있다. 
		 */
		try {
			URL u = new URL("http://naver.com");
			URLConnection conn = u.openConnection();
			System.out.println(conn.guessContentTypeFromName("D:/Chrysanthemum.jpg"));
			
			InputStream is = new FileInputStream(new File("D:/Chrysanthemum.jpg"));
			BufferedInputStream bis = new BufferedInputStream(is);
			System.out.println(conn.guessContentTypeFromStream(bis));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
