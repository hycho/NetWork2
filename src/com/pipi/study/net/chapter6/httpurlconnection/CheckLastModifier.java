/*
 * HttpURLConnection의 setRequestMethod를 HEAD를 인자로 넘겨 HEADER정볼르 받고 해더의 마지막 수정 일자를 화면에 표시한다.
 */
package com.pipi.study.net.chapter6.httpurlconnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class CheckLastModifier {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://shopping.phinf.naver.net/20151016_20/4fd05e46-710c-43bf-b383-325830e78d65.jpg");
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("HEAD");
			System.out.println(u + " was last modified at " + new Date(conn.getLastModified()));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
