package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckUrlInfo {

	public static void main(String[] args) {
		/**
		 * String getProtocol() : URL�� ���������� ���ڿ��� �����Ѵ�.
		 * String getHost() : ȣ��Ʈ ������ ���ڿ��� ��ȯ�Ѵ�.
		 * int getPort() : ��Ʈ�� ��ȯ�Ѵ�. ��Ʈ�� ������ -1�� ��ȯ�ϸ� URL�� �������ݿ� �´� �⺻ ��Ʈ�� ����Ѵ�.
		 * int getDefaultPort() : URL�� ���ǵ� ��Ʈ�� ������� ���������� �⺻ ��Ʈ�� ��ȯ�Ѵ�. ��Ʈ�� ���ǵ��� ���� ���������� ��� -1�� ��ȯ�Ѵ�.
		 * String getFile() : URL�� ��θ� ���ڿ��� ��ȯ�ϸ�, ù��° ������(/) ���� #��ȣ ���������� ��ȯ�Ѵ�.
		 * String getPath() : getFile�� ���� ����ϸ� ���� ���ڿ�(?&)�� �������Ѵ�.
		 * String getRef() : #���� ���� ������ �κ��� ��ȯ�Ѵ�. ���� ��� null�� ��ȯ�Ѵ�.
		 * String getQuery() : �������ڿ�(?&)�� ��ȯ�Ѵ�.
		 * String getAuthority() : �������� ���� �κк��� ��Ʈ���� ��ȯ�Ѵ�. URL�� "ftp://admin:admin@test.com:9090/test"�ϰ�� admin:admin@test.com:9090���� ��ȯ�Ѵ�.
		 * String getUserInfo() : ftp������� ���� ID�� �н����尰�� ����� ������ ��ȯ�Ѵ�. URL�� "ftp://admin:admin@test.com:9090/test"�ϰ�� admin:admin�� ��ȯ�Ѵ�.
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
