package com.pipi.study.net.chapter10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class GenTextClient {
	public static void main(String[] args) {
		nonBlockmode();
	}
	
	public static void blockmode() {
		try {
			SocketAddress rama = new InetSocketAddress("rama.poly.edu", 19);
			SocketChannel client = SocketChannel.open(rama);
			
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel output = Channels.newChannel(System.out);
			
			while(client.read(buffer) != -1) {
				buffer.flip();
				output.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public static void nonBlockmode() {
		try {
			SocketAddress rama = new InetSocketAddress("rama.poly.edu", 19);
			SocketChannel client = SocketChannel.open(rama);
			client.configureBlocking(false); //nonblock모드 설저
			
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel output = Channels.newChannel(System.out);
			
			while(true) {
				int n = client.read(buffer);
				if(n > 0) {
					buffer.flip();
					output.write(buffer);
					buffer.clear();
				} else if (n == -1) {
					break;
				}
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
}
