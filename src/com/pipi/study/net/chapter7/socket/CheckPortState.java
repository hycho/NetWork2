package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CheckPortState {

	public static void main(String[] args) {
		String host = "localhost";
		
		for(int i=1; i < 1024; i++) {
			try {
				Socket socket = new Socket(host, i);
				System.out.println("There is a server on port " + i + " of " + host);
				socket.close();
			} catch(UnknownHostException e) {
				System.err.println(e);
				break;
			} catch(IOException e) {
				System.out.println("There is a server not on port " + i + " of " + host);
			}
		}
	}

}
