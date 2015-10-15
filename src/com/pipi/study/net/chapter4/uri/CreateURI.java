package com.pipi.study.net.chapter4.uri;

import java.net.URI;
import java.net.URISyntaxException;

public class CreateURI {

	public static void main(String[] args) {
		/**
		 * URI(String str) : 구문 규칙에 맞는 url을 파라메터로 URI객체를 생성한다.
		 * URI(String scheme, String ssp, String fragment) : scheme는 일반적인 프로토로, ssp는 프로토콜에 따른 구문, fragment는 부위지정자(#)을 뜻하며 이 데이터를 사용해 URI객체를 생성한다.
		 * URI(String scheme, String host, String path, String fragment) : 프로토콜, 호스트, 패스, 부위지정자를 사용하여 URI를 생성한다.
		 * URI(String scheme, String authority, String path, String query, String fragment) : 프로토콜, 호스트, 경로, 쿼리문자열, 부위지정자를 사용하여 URI를 생성한다.
		 * URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment) : 프로토콜, 유저정보, 호스트, 포트, 경로, 쿼리문자열, 부위지정자를 사용해 URI를 생성한다.
		 * URI create(String str) : str을 통해 URI를 생성 한다.
		 */
		
		try {
			URI phone = new URI("phone:010-777-8888");
			URI naver = new URI("http://naver.com");
			URI book = new URI("urn:isbn:1-550-77123-1");
			
			System.out.println(phone);
			System.out.println(naver);
			System.out.println(book);
			
			URI daum = new URI("http", "//daum.net", null);  
			URI relativeURI = new URI(null, "/test/test.html", "good");	//1번째 인자 scheme가 null일경우 상대적 URI를 만든다
			
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
