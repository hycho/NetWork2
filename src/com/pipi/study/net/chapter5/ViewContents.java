package com.pipi.study.net.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ViewContents {

	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [��ǥ������ ���ȴ�.] URL�� ���� ������ ���ҽ��� �����ϰ� �״��� 3 way handshaking�� ó���� �� ���ҽ� ���� �����͸� ���� �� �ִ� InputStream��ü�� �����Ѵ�.
		 * URLConnection openConnection() : URL�� ���� ������ ���ҽ��� �����ϰ� ó���� �� �� ���ҽ� ���� �������� ������ ���� �� �ִ� URLConnection�� �����Ѵ�.
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent()
		 * Object getContent(Class[] classes)
		 */
		try {
			URL url = new URL("http://naver.com");
			URLConnection urlConn = url.openConnection();
			InputStream in = urlConn.getInputStream();
			
			Map<String, List<String>> headersMap = urlConn.getHeaderFields();
			headersMap.keySet();
			
	        for(String key : headersMap.keySet()) {
	            System.out.println(key + " = " + headersMap.get(key));
	        }
		} catch (IOException e) {
			System.err.print(e);
		} 
	}

}
