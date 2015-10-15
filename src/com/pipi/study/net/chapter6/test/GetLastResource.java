package com.pipi.study.net.chapter6.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class GetLastResource {

	public static void main(String[] args) throws IOException {
		String encoding = "ISO-8859-1";
		try {
			URL url = new URL("http://naver.com");
			URLConnection conn = url.openConnection();
			conn.setUseCaches(false);	//캐쉬를 타지 않고 서버에서 새롭게 데이터를 받아온다.
			
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
