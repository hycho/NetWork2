package com.pipi.study.net.chapter6;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {

	public static void main(String[] args) {
		try {
			URL u = new URL("Http://naver.com");
			URLConnection uconn = u.openConnection();

			for(int i = 1; ; i++) {
				String header = uconn.getHeaderField(i);
				if(header == null) break;
				System.out.println(uconn.getHeaderFieldKey(i)+" = "+header);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
