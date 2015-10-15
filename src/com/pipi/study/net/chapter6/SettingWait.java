package com.pipi.study.net.chapter6;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class SettingWait {

	public static void main(String[] args) throws IOException {
		/**
		 * public void setConnectTimeout(int timeout)	// 초기 연결시 소켓이 기다리는 시간 설정.
		 * public int getConnectTimeout()				// 초기 연결시 소켓이 기다리는 시간을 리턴한다.
		 * public void setReadTimeout(int timeout)		// 입력 스트림이 데이터의 도착을 기다리는 시간 설정.
		 * public int getReadTimeout()					// 입력 스트림이 데이터의 도착을 기다리는 시간을 리턴한다.
		 */
		String encoding = "ISO-8859-1";
		try {
			URL url = new URL("http://naver.com");
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(30000); //30초동안의 서버 타임아웃 시간을 설정한다.
			conn.setReadTimeout(45000); //45초동안의 데이터 일기 타임아웃 시간을 설정한다.
			
			String contentType = conn.getContentType();
			int encodingStart = contentType.indexOf("charset=");
			
			if(encodingStart != -1) {
				encoding = contentType.substring(encodingStart + 8);
				InputStream in = new BufferedInputStream(conn.getInputStream());
				Reader r = new InputStreamReader(in, encoding);
				int c;
				while((c = r.read()) != -1) {
					System.out.print((char) c);
				}
				r.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
