package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

public class TestSocketAddress {

	public static void main(String[] args) {
		try(
			Socket socket = new Socket("www.naver.com", 80);
			Socket socket2 = new Socket();
		) {
			SocketAddress naver = socket.getRemoteSocketAddress();	//SocketAddress를 구한다.
			socket.close();	//소켓을 닫는다.
			
			socket2.connect(naver);	//SocketAddress를 통해서 재 연결.
			
			behive(socket2);
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
