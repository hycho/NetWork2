package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;

public class LocalPortScannerWithNoParamConstructure {
	public static void main(String[] args) {
		for(int port=1; port <= 65535; port++) {
			try {
				ServerSocket ss = new ServerSocket();
				SocketAddress http = new InetSocketAddress(port); //만약 Null을 넘길 경우 시스템이 사용 가능한 포트를 알아서 설정해준다.
				ss.bind(http);
			} catch (IOException e) {
				System.err.println("There is a server on port " + port + ".");
			}
		}
	}
}
