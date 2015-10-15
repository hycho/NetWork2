package com.pipi.study.net.chapter6;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class SettingWait {

	public static void main(String[] args) throws IOException {
		/**
		 * public void setConnectTimeout(int timeout)	// �ʱ� ����� ������ ��ٸ��� �ð� ����.
		 * public int getConnectTimeout()				// �ʱ� ����� ������ ��ٸ��� �ð��� �����Ѵ�.
		 * public void setReadTimeout(int timeout)		// �Է� ��Ʈ���� �������� ������ ��ٸ��� �ð� ����.
		 * public int getReadTimeout()					// �Է� ��Ʈ���� �������� ������ ��ٸ��� �ð��� �����Ѵ�.
		 */
		String encoding = "ISO-8859-1";
		try {
			URL url = new URL("http://naver.com");
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(30000); //30�ʵ����� ���� Ÿ�Ӿƿ� �ð��� �����Ѵ�.
			conn.setReadTimeout(45000); //45�ʵ����� ������ �ϱ� Ÿ�Ӿƿ� �ð��� �����Ѵ�.
			
			String contentType = conn.getContentType();
			int encodingStart = contentType.indexOf("charset=");
			
			if(encodingStart != -1) {
				encoding = contentType.substring(encodingStart + 8);
				InputStream in = new BufferedInputStream(conn.getInputStream());
				Reader r = new InputStreamReader(in, encoding);
				int c;
				while((c = r.read()) != -1) {
					System.out.print((char) c);
				}
				r.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
