package com.pipi.study.net.chapter6.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLPrinter {

	public static void main(String[] args) {
		/**
		 * protected URL url : URL�� URLConnection�� �����ϰ��� �ϴ� URL�� ǥ���ϸ� URLConnection�� ��������� �����ڿ� ���� �����Ǹ� �� �Ŀ��� ���� �Ǽ��� �ȵȴ�. 
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
