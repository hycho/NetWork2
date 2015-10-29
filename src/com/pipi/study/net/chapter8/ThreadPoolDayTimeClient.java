package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadPoolDayTimeClient {
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("localhost", 13);
			behive(s);
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static void behive(Socket socket) throws IOException {
		try(InputStream in = socket.getInputStream();) {
			InputStreamReader reader = new InputStreamReader(in);
			
			StringBuilder payload = new StringBuilder();
			
			for(int c = reader.read(); c!=-1; c=reader.read()) {
				payload.append((char) c);
			}

			System.out.println(payload.toString());
		} catch (IOException e){
			System.err.println(e);
		}
	}
}
