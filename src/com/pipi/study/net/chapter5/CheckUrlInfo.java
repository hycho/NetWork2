package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckUrlInfo {

	public static void main(String[] args) {
		/**
		 * String getProtocol() : URL의 프로토콜을 문자열로 리턴한다.
		 * String getHost() : 호스트 네임을 문자열로 반환한다.
		 * int getPort() : 포트를 반환한다. 포트가 없으면 -1을 반환하며 URL은 프로토콜에 맞는 기본 포트를 사용한다.
		 * int getDefaultPort() : URL에 정의된 포트가 없을경우 프로토콜의 기본 포트를 반환한다. 포트가 정의되지 않은 프로토콜의 경우 -1을 반환한다.
		 * String getFile() : URL의 경로를 문자열로 반환하며, 첫번째 슬러시(/) 부터 #기호 이전까지를 반환한다.
		 * String getPath() : getFile과 거의 비슷하며 쿼리 문자열(?&)를 미포함한다.
		 * String getRef() : #같은 부위 지정자 부분을 반환한다. 없을 경우 null을 반환한다.
		 * String getQuery() : 쿼리문자열(?&)을 반환한다.
		 * String getAuthority() : 프로토콜 다음 부분부터 포트까지 반환한다. URL이 "ftp://admin:admin@test.com:9090/test"일경우 admin:admin@test.com:9090까지 반환한다.
		 * String getUserInfo() : ftp같은경우 유저 ID나 패스워드같은 사용자 정보를 반환한다. URL이 "ftp://admin:admin@test.com:9090/test"일경우 admin:admin을 반환한다.
		 */

		String strUrl = "http://devnerd.tistory.com/plugin/CallBack_bootstrapperSrc?nil_profile=tistory&nil_type=copied_post";
		try {
			URL url = new URL(strUrl);
			
			System.out.println("URL is = "+url);
			System.out.println("Protocol is = "+url.getProtocol());
			System.out.println("Host is = "+url.getHost());
			System.out.println("Port is = "+url.getPort());
			System.out.println("Default port is = "+url.getDefaultPort());
			System.out.println("File is = "+url.getFile());
			System.out.println("Path is = "+url.getPath());
			System.out.println("Ref is = "+url.getRef());
			System.out.println("Query String is = "+url.getQuery());
			System.out.println("Authority = "+url.getAuthority());
			System.out.println("User info is = "+url.getUserInfo());
			
		} catch (MalformedURLException e) {
			System.err.println(e);
		}
	}

}
