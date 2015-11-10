package com.pipi.study.net.chapter9;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HttpSslClient {
	private static final int port = 443;
	private static final String host = "www.usps.com"; 
	
	public static void main(String[] args) {
		SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket sslSocket = null;
		
		try {
			sslSocket = (SSLSocket) sslFactory.createSocket(host, port);
			
			// 모든 암호화 조합을 사용하기 위해 SSLSocket에서 지원하는 모든 암호화 List를 받아옴
			String[] supported = sslSocket.getSupportedCipherSuites();
			sslSocket.setEnabledCipherSuites(supported); //모든 암호화 조합을 사용하도록 설정.
			
			Writer out = new OutputStreamWriter(new BufferedOutputStream(sslSocket.getOutputStream()));
			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("\r\n");
			out.flush();
			
			// 응답 읽기
			BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
			
			// 헤더 출력
			String header;
			while(!(header = in.readLine()).equals("")) {
				System.out.println(header);
			}
			System.out.println();
			
			// content length 확인
			String contentLength = in.readLine();
			int length = Integer.MAX_VALUE;
			
			try{
				length = Integer.parseInt(contentLength.trim(), 16);
			} catch(NumberFormatException ex) {}
			
			System.out.println("Content length = " + length);
			
			int c;
			int i = 0;
			while((c = in.read()) != -1 && i++ < length) {
				System.out.write(c);
			}
			
			System.out.println();
		} catch(IOException e) {
			System.err.println(e);
		}
		
	}
}
