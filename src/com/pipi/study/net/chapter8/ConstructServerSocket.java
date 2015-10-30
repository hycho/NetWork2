package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.net.ServerSocket;

public class ConstructServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
