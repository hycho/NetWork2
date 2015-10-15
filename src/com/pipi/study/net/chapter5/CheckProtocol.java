package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckProtocol {

	public static void main(String[] args) {
		/**
		 * URL(String url) : url을 통해서 URL객체를 생성한다.
		 * URL(String protocol, String hostname, String file) : 프로토콜, 호스트네임, file은 '/'로 시작해야한다 port는 프로토콜의 기본 포트번호를 사용한다. 이 정보를 토대로 URL 객체를 생성한다.
		 * URL(String protocol, String hostname, int port, String file) : 프로토콜, 호스트네임, port, file을 사용하여 URL객체를 생성한다.
		 * URL(URL base, String relative) : base이름을 가진 URL 객체로부터 상대적인 URL(relative)를 사용하여 새로운 URL 객체를 생성한다.  
		 */
		
		//http 프로토콜
		checkProtocol("http://naver.com");

		//https 프로토콜
		checkProtocol("https://naver.com");
		
		//ftp프로토콜
		checkProtocol("ftp://naver.com/test/");
		
		//간이 메일 전송 프로토콜
		checkProtocol("mailto:admin@google.co.kr");
		
		//텔넷
		checkProtocol("telnet://naver.com/");
		
		//로컬 파일 접근
		checkProtocol("file://D:/test.txt");
		
		// gopher
		checkProtocol("gopher://gopher.anc.org.za/");
		
		// ldap
		checkProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
		
		// jar
		checkProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!/com/macfaq/io/StreamCopier.class");
		
		// NFS, 네트워크 파일 시스템
		checkProtocol("nfs://utopia.poly.edu/usr/tmp/");
		
		// jdbc -> 실제 지원안하는 것처럼 보이지만 java.sql을 통해서 별도로 지원한다.
		checkProtocol("jdbc:mysql://localhost:3306/db_dragon");
		
		// rmi, 원격 메소드 호출을 위한 사용자 정의 프로토콜 -> 실제 지원을 하지 않는 것 처럼 보이지만 java.rmi를 통해 별도로 지원한다.
		checkProtocol("rmi://naver.com/test");
		
		// HotJava를 위한 사용자 정의 프로토콜
		checkProtocol("doc://naver.com");
		checkProtocol("netdoc://naver.com");
		checkProtocol("systemresource://naver.com");
		checkProtocol("verbatim://naver.com");
		
		System.out.println("");
		
		// 기반 URL과 상대적 URL을 통해 새로운 URL을 생성한다.
		try {
			URL url1 = new URL("http://naver.com/test/a.gif");
			URL url2 = new URL(url1, "b.gif");
			System.out.println(url2);	// return http://naver.com/test/b.gif
		} catch (MalformedURLException e) {
			System.err.println(e);
		}
		
	}
	
	private static void checkProtocol(String url) {
		try {
			URL checkUrl = new URL(url);
			System.out.println(checkUrl.getProtocol() + "is supported");
		} catch (MalformedURLException e) {
			String protocol = url.substring(0, url.indexOf(':'));
			System.err.println(protocol + " is not supported");
		}
	}

}
