package com.pipi.study.net.chapter6;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class CheckAllowUserInteraction {

	public static void main(String[] args) {
		try {
			URL u = new URL("http://naver.com");
			URLConnection conn = u.openConnection();
			conn.setAllowUserInteraction(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
