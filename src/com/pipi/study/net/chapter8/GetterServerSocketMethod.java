package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class GetterServerSocketMethod {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket();
			SocketAddress http = new InetSocketAddress(0); //만약 0을 넘길 경우 시스템이 사용 가능한 포트를 알아서 설정해준다.
			ss.bind(http);
			
			System.out.println(ss.getInetAddress());	// 바인딩된 서버 IP 반환
			System.out.println(ss.getLocalPort());	// 바인딩된 서버 포트 반환
		} catch (IOException e) {}
	}
}
