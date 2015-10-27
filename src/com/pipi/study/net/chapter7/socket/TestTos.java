package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestTos {
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("time.nist.gov", 13);
			s.setTrafficClass(0x26); // 10111000
			int c = 0x26;
			System.out.println(c);
			behive(s);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
