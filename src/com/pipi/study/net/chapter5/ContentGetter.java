package com.pipi.study.net.chapter5;

import java.io.IOException;
import java.net.URL;

public class ContentGetter {

	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [��ǥ������ ���ȴ�.] URL�� ���� ������ ���ҽ��� �����ϰ� �״��� 3 way handshaking�� ó���� �� ���ҽ� ���� �����͸� ���� �� �ִ� InputStream��ü�� �����Ѵ�.
		 * URLConnection openConnection() : URL�� ���� ������ ���ҽ��� �����ϰ� ó���� �� �� ���ҽ� ���� �������� ������ ���� �� �ִ� URLConnection�� �����Ѵ�.
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent() : URL�� ����Ű�� ���ҽ��� ����� Ÿ���� Object�� �����Ѵ�. ���ҽ� Header�� Content-type�� ���� �Ǵ��Ѵ�. ���� Content-Type�� ���� ��� Inputsteram���� �� �� ������ �����Ѵ�.
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
