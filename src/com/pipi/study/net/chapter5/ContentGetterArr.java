package com.pipi.study.net.chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

public class ContentGetterArr {

	public static void main(String[] args) {
		/**
		 * InputStream openStream() : [��ǥ������ ���ȴ�.] URL�� ���� ������ ���ҽ��� �����ϰ� �״��� 3 way handshaking�� ó���� �� ���ҽ� ���� �����͸� ���� �� �ִ� InputStream��ü�� �����Ѵ�.
		 * URLConnection openConnection() : URL�� ���� ������ ���ҽ��� �����ϰ� ó���� �� �� ���ҽ� ���� �������� ������ ���� �� �ִ� URLConnection�� �����Ѵ�.
		 * URLConnection openConnection(Proxy proxy)
		 * Object getContent() : URL�� ����Ű�� ���ҽ��� ����� Ÿ���� Object�� �����Ѵ�. ���ҽ� Header�� Content-type�� ���� �Ǵ��Ѵ�. ���� Content-Type�� ���� ��� Inputsteram���� �� �� ������ �����Ѵ�.
		 * Object getContent(Class[] classes) : classes�迭 ������� ������ ������ ���·� ������ �Ѵ�.
		 */
		try {
			URL url = new URL("http://naver.com");
			Class<?>[] types = new Class[3];
			types[0] = String.class; //String��ȯ�� �����ϸ� String��ȯ
			types[1] = Reader.class; //String��ȯ�� �Ұ����ϰ� Reader�� ��ȯ�ɼ� ������ Reader���·� ��ȯ
			types[2] = InputStream.class; //String, Reader�Ѵ� �Ұ��� �ϴٸ� InputStream���� ��ȯ
			
			Object obj = url.getContent(types); // �迭 ������� ��ȯ�� ������ ���¶�� ��ȯ�� �Ѵ�.
			
			System.out.println(obj.getClass());
			
		} catch (IOException e) {
			System.err.print(e);
		} 
	}

}
