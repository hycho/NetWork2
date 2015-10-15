package com.pipi.study.net.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class ContentGetterArr {

	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [대표적으로 사용된다.] URL에 의해 참조된 리소스에 연결하고 그다음 3 way handshaking을 처리한 후 리소스 원본 데이터를 읽을 수 있는 InputStream객체를 리턴한다.
		 * URLConnection openConnection() : URL에 의해 참조된 리소스에 연결하고 처리를 한 후 리소스 원본 데이터의 정보를 구할 수 있는 URLConnection을 리턴한다.
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent() : URL이 가르키는 리소스를 비슷한 타입의 Object로 리턴한다. 리소스 Header의 Content-type을 통해 판단한다. 만약 Content-Type이 없을 경우 Inputsteram형태 중 한 종류를 리턴한다.
		 * Object getContent(Class[] classes) : classes배열 순서대로 리턴이 가능한 형태로 리턴을 한다.
		 */
		try {
			URL url = new URL("http://naver.com");
			Class<?>[] types = new Class[3];
			types[0] = String.class; //String반환이 가능하면 String반환
			types[1] = Reader.class; //String반환이 불가능하고 Reader가 반환될수 있으면 Reader형태로 반환
			types[2] = InputStream.class; //String, Reader둘다 불가능 하다면 InputStream으로 반환
			
			Object obj = url.getContent(types); // 배열 순서대로 반환이 가능한 형태라면 반환을 한다.
			
			System.out.println(obj.getClass());
			
		} catch (IOException e) {
			System.err.print(e);
		} 
	}

}
