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
			
			if(uri.isOpaque()) { //��� url�� ������(���Ŀ� ���� ����)�� ��� true ���� �Ѵ�.
				//�������� URI�� ��� ��������(��Ű��), ����������, ���η����ݽ������� ���� Ȯ�� �� �� �ִ�.
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
