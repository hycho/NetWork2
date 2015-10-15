package com.pipi.study.net.chapter4.uri;

import java.net.URI;
import java.net.URISyntaxException;

public class CreateURI {

	public static void main(String[] args) {
		/**
		 * URI(String str) : ���� ��Ģ�� �´� url�� �Ķ���ͷ� URI��ü�� �����Ѵ�.
		 * URI(String scheme, String ssp, String fragment) : scheme�� �Ϲ����� �������, ssp�� �������ݿ� ���� ����, fragment�� ����������(#)�� ���ϸ� �� �����͸� ����� URI��ü�� �����Ѵ�.
		 * URI(String scheme, String host, String path, String fragment) : ��������, ȣ��Ʈ, �н�, ���������ڸ� ����Ͽ� URI�� �����Ѵ�.
		 * URI(String scheme, String authority, String path, String query, String fragment) : ��������, ȣ��Ʈ, ���, �������ڿ�, ���������ڸ� ����Ͽ� URI�� �����Ѵ�.
		 * URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment) : ��������, ��������, ȣ��Ʈ, ��Ʈ, ���, �������ڿ�, ���������ڸ� ����� URI�� �����Ѵ�.
		 * URI create(String str) : str�� ���� URI�� ���� �Ѵ�.
		 */
		
		try {
			URI phone = new URI("phone:010-777-8888");
			URI naver = new URI("http://naver.com");
			URI book = new URI("urn:isbn:1-550-77123-1");
			
			System.out.println(phone);
			System.out.println(naver);
			System.out.println(book);
			
			URI daum = new URI("http", "//daum.net", null);  
			URI relativeURI = new URI(null, "/test/test.html", "good");	//1��° ���� scheme�� null�ϰ�� ����� URI�� �����
			
			System.out.println(daum);
			System.out.println(relativeURI);

			URI jpgUri = new URI("http", "shopping.phinf.naver.net", "/20150915_5/5b0a6b5a-ed6c-4273-b3b3-df8e2a0c6532.jpg", "today");
			System.out.println(jpgUri);
			
			URI videoUri = new URI("http", "sports.news.naver.com", "/videoCenter/index.nhn", "uCategory=kbaseball&amp;category=kbo&amp;listType=total&amp;id=154375", "champ");
			System.out.println(videoUri);
			
			URI segyeUri = new URI("http", null, "www.segye.com", 80,"/content/html/2015/09/26/20150926000098.html", null, null);
			System.out.println(segyeUri);
			
			URI createGoogleUri = URI.create("http://google.co.kr");
			System.out.println(createGoogleUri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
