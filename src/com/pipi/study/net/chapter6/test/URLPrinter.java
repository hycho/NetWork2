package com.pipi.study.net.chapter6.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLPrinter {

	public static void main(String[] args) {
		/**
		 * protected URL url : URL은 URLConnection이 연결하고자 하는 URL을 표시하며 URLConnection이 만들어질때 생성자에 의해 설정되며 그 후에는 변경 되서는 안된다. 
		 */
		try {
			URL u = new URL("http://naon.go.kr");
			URLConnection conn = u.openConnection();
			System.out.println(conn.getURL());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
