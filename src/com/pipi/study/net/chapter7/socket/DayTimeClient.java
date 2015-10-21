package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DayTimeClient {

	public static void main(String[] args) {
		String hostname = "time.nist.gov";
		Socket socket = null;
		
		try {
			socket = new Socket(hostname, 13);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in);
			for(int c = reader.read(); c!=-1; c=reader.read()) {
				time.append((char) c);
			}
			System.out.println(time);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
