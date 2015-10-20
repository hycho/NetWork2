package com.pipi.study.net.chapter6.responsecode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetErrorPage {

	public static void main(String[] args) throws IOException {
		URL u = new URL("http://naver.com/fsa");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		try(InputStream is = conn.getInputStream()) {
			printStream(is);
		} catch(Exception e) {
			System.out.println("Call Error Page");
			printStream(conn.getErrorStream());	//getInputStream()메소드 호출이 실패할 경우 실행 된다.
		}
	}
	
	public static void printStream(InputStream is) {
		try(InputStream bis = new BufferedInputStream(is)) {
			Reader reader = new InputStreamReader(bis, "UTF-8");
			int read;
			while((read = reader.read()) != -1) {
				System.out.print((char) read);
			}
		} catch(Exception e) {
			
		}
	}

}
