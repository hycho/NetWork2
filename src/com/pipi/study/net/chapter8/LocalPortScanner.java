package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {
	public static void main(String[] args) {
		for(int port=1; port <= 65535; port++) {
			try {
				ServerSocket ss = new ServerSocket(port);
			} catch (IOException e) {
				System.err.println("There is a server on port " + port + ".");
			}
		}
	}
}
