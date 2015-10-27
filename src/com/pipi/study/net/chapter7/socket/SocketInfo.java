package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketInfo {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("www.naver.com", 80);
			System.out.println("Connect to " + s.getInetAddress());
			System.out.println("Connect port to " + s.getPort());
			System.out.println("Connect from " + s.getLocalAddress());
			System.out.println("Connect port from " + s.getLocalPort());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
