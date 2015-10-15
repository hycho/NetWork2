/**
 * URLConnection�� ���ؼ� POST�� �����͸� ���� �ϴ� ����.
 */

package com.pipi.study.net.chapter6.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class PostSend {
	
	public static void main(String[] args) {
		String encoding = "UTF-8";
		try {
			URL u = new URL("http://krdic.naver.com/search.nhn");
			URLConnection conn = u.openConnection();
			conn.setDoOutput(true);	//������ �����͸� �������� ���⸦ Ȱ��ȭ �Ѵ�.
			
			OutputStream raw = conn.getOutputStream();
			OutputStream bufOut = new BufferedOutputStream(raw);
			OutputStreamWriter out = new OutputStreamWriter(bufOut, "UTF-8");
			
			out.write("query=111&kind=all");
			
			String contentType = conn.getContentType();
			InputStream in = new BufferedInputStream(conn.getInputStream());
			Reader r = new InputStreamReader(in, encoding);
			int c;
			while((c = r.read()) != -1) {
				System.out.print((char) c);
			}
			r.close();

			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
