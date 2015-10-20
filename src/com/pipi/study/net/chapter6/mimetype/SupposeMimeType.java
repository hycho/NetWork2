package com.pipi.study.net.chapter6.mimetype;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SupposeMimeType {

	public static void main(String[] args) {
		/**
		 * guessContentTypeFromName(String name) : name�� Ȯ���� �κ��� ������� ��ü�� ������ Ÿ���� �����ϰ� ��ȯ�Ѵ�..
		 * guessContentTypeFromStream(InputStream is) : stream�� ��� ���� ����Ʈ�� �а� Ÿ���� �ĺ��Ѵ�. guessContentTypeFromName���� �ŷ��ϱ� ������ ���� ��� XML���� ���� XML�� �ƴ� �ּ����� ������ ��� HTML���Ϸ� �߸� �з��� �� �� �ִ�. 
		 */
		try {
			URL u = new URL("http://naver.com");
			URLConnection conn = u.openConnection();
			System.out.println(conn.guessContentTypeFromName("D:/Chrysanthemum.jpg"));
			
			InputStream is = new FileInputStream(new File("D:/Chrysanthemum.jpg"));
			BufferedInputStream bis = new BufferedInputStream(is);
			System.out.println(conn.guessContentTypeFromStream(bis));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
