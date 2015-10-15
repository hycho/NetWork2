package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class CheckUriInfo {

	public static void main(String[] args) {
		/**
		 * String getScheme()
		 * String getSchemeSpecificPart()
		 */
		String strUri = "http://devnerd.tistory.com/plugin/CallBack_bootstrapperSrc?nil_profile=tistory&nil_type=copied_post";
		URI uri;
		try {
			uri = new URI(strUri);
			System.out.println("The URI is " + uri);
			
			if(uri.isOpaque()) { //대상 url이 불투명(형식에 맞지 않음)일 경우 true 리턴 한다.
				//불투명한 URI인 경우 프로토콜(스키마), 부위지정자, 프로로토콜스팩정보 만을 확인 할 수 있다.
				System.out.println("This is Opaque URI");
				System.out.println("The scheme is = " + uri.getScheme());
				System.out.println("The scheme spec part is = " + uri.getRawSchemeSpecificPart());
				System.out.println("The fragment ID is = " + uri.getFragment());
			} else {
				System.out.println("This is hierarchical URI");
				uri = uri.parseServerAuthority();
				System.out.println("The host is = " + uri.getHost());
				System.out.println("The port is = " + uri.getPort());
				System.out.println("");
			}
			
			System.out.println("The authority is = " + uri.getAuthority());
			System.out.println("The path is = " + uri.getPath());
			System.out.println("The query string is = " + uri.getQuery());
			System.out.println("The fragment ID is = " + uri.getFragment());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
