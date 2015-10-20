/*
 * HttpURLConnection의 setRequestMethod를 HEAD를 인자로 넘겨 HEADER정볼르 받고 해더의 마지막 수정 일자를 화면에 표시한다.
 */
package com.pipi.study.net.chapter6.httpurlconnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CheckOption {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://naver.com");
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("OPTIONS");
			
			Map<String, List<String>> headersMap = conn.getHeaderFields();
			headersMap.keySet();
			
	        for(String key : headersMap.keySet()) {
	            System.out.println(key + " = " + headersMap.get(key));
	        }
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
