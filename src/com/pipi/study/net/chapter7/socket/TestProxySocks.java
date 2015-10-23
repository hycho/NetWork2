package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

public class TestProxySocks {

	public static void main(String[] args) {
		try {
			SocketAddress proxyAddress = new InetSocketAddress("109.131.85.93", 27469);
			Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);
			Socket s = new Socket(proxy);
			SocketAddress time = new InetSocketAddress("time.nist.gov", 13);
			s.connect(time);
			behive(s);
		} catch (IOException e) {
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
