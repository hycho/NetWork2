package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckProtocol {

	public static void main(String[] args) {
		/**
		 * URL(String url) : url�� ���ؼ� URL��ü�� �����Ѵ�.
		 * URL(String protocol, String hostname, String file) : ��������, ȣ��Ʈ����, file�� '/'�� �����ؾ��Ѵ� port�� ���������� �⺻ ��Ʈ��ȣ�� ����Ѵ�. �� ������ ���� URL ��ü�� �����Ѵ�.
		 * URL(String protocol, String hostname, int port, String file) : ��������, ȣ��Ʈ����, port, file�� ����Ͽ� URL��ü�� �����Ѵ�.
		 * URL(URL base, String relative) : base�̸��� ���� URL ��ü�κ��� ������� URL(relative)�� ����Ͽ� ���ο� URL ��ü�� �����Ѵ�.  
		 */
		
		//http ��������
		checkProtocol("http://naver.com");

		//https ��������
		checkProtocol("https://naver.com");
		
		//ftp��������
		checkProtocol("ftp://naver.com/test/");
		
		//���� ���� ���� ��������
		checkProtocol("mailto:admin@google.co.kr");
		
		//�ڳ�
		checkProtocol("telnet://naver.com/");
		
		//���� ���� ����
		checkProtocol("file://D:/test.txt");
		
		// gopher
		checkProtocol("gopher://gopher.anc.org.za/");
		
		// ldap
		checkProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
		
		// jar
		checkProtocol("jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!/com/macfaq/io/StreamCopier.class");
		
		// NFS, ��Ʈ��ũ ���� �ý���
		checkProtocol("nfs://utopia.poly.edu/usr/tmp/");
		
		// jdbc -> ���� �������ϴ� ��ó�� �������� java.sql�� ���ؼ� ������ �����Ѵ�.
		checkProtocol("jdbc:mysql://localhost:3306/db_dragon");
		
		// rmi, ���� �޼ҵ� ȣ���� ���� ����� ���� �������� -> ���� ������ ���� �ʴ� �� ó�� �������� java.rmi�� ���� ������ �����Ѵ�.
		checkProtocol("rmi://naver.com/test");
		
		// HotJava�� ���� ����� ���� ��������
		checkProtocol("doc://naver.com");
		checkProtocol("netdoc://naver.com");
		checkProtocol("systemresource://naver.com");
		checkProtocol("verbatim://naver.com");
		
		System.out.println("");
		
		// ��� URL�� ����� URL�� ���� ���ο� URL�� �����Ѵ�.
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
