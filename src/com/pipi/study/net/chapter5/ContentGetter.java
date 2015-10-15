package com.pipi.study.net.chapter5;

import java.io.IOException;
import java.net.URL;

public class ContentGetter {

	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [대표적으로 사용된다.] URL에 의해 참조된 리소스에 연결하고 그다음 3 way handshaking을 처리한 후 리소스 원본 데이터를 읽을 수 있는 InputStream객체를 리턴한다.
		 * URLConnection openConnection() : URL에 의해 참조된 리소스에 연결하고 처리를 한 후 리소스 원본 데이터의 정보를 구할 수 있는 URLConnection을 리턴한다.
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent() : URL이 가르키는 리소스를 비슷한 타입의 Object로 리턴한다. 리소스 Header의 Content-type을 통해 판단한다. 만약 Content-Type이 없을 경우 Inputsteram형태 중 한 종류를 리턴한다.
		 * Object getContent(Class[] classes)
		 */
		try {
			URL url = new URL("http://naver.com");
			URL imgUrl = new URL("http://ts.daumcdn.net/static/banner/center/2014best_center.jpg");
			Object obj = url.getContent();
			Object imgObj = imgUrl.getContent();
			System.out.println(obj.getClass());
			System.out.println(imgObj.getClass());
		} catch (IOException e) {
			System.err.print(e);
		} 
	}

}
