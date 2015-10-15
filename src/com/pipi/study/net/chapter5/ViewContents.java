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
		 * InputStream openStream() : [대표적으로 사용된다.] URL에 의해 참조된 리소스에 연결하고 그다음 3 way handshaking을 처리한 후 리소스 원본 데이터를 읽을 수 있는 InputStream객체를 리턴한다.
		 * URLConnection openConnection() : URL에 의해 참조된 리소스에 연결하고 처리를 한 후 리소스 원본 데이터의 정보를 구할 수 있는 URLConnection을 리턴한다.
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
