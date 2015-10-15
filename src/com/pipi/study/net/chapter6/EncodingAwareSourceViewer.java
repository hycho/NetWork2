package com.pipi.study.net.chapter6;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class EncodingAwareSourceViewer {

	public static void main(String[] args) {
		String encoding = "ISO-8859-1";
		try {
			URL url = new URL("http://naver.com");
			URLConnection conn = url.openConnection();
			
			String contentType = conn.getContentType();
			System.out.println("http://naver.com's content type is = "+contentType); //http://naver.com's content type is = text/html; charset=UTF-8
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
