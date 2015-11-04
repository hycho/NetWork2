package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

public class ServerSocketOption {
	public static void main(String[] args) {
		//soTimeout();
		//soReuseAddr();
		//soRcvbuf();
		//setRcvbuf();
		checkSetPerformancePreferences();
	}
	
	public static void soTimeout() {
		try(ServerSocket ss = new ServerSocket(80);) {
			ss.setSoTimeout(5000); //Timeout 5초 설정.
			System.out.println("timeout is " + ss.getSoTimeout() + " miliseconds");
			ss.accept();
		} catch(SocketTimeoutException e) {
			System.err.println(e);
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}
	
	public static void soReuseAddr() {
		try(ServerSocket ss = new ServerSocket(80);) {
			System.out.println("Reusable : " + ss.getReuseAddress());
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}
	
	public static void soRcvbuf() {
		try(ServerSocket ss = new ServerSocket(80);) {
			System.out.println("Default ReceiveBufferSize is : " + ss.getReceiveBufferSize());
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}
	
	public static void setRcvbuf() {
		try(ServerSocket ss = new ServerSocket();) {
			int receiveBufferSize = ss.getReceiveBufferSize();
			System.out.println("receiveBufferSize is " + receiveBufferSize);
			if(receiveBufferSize < 131072) {
				ss.setReceiveBufferSize(131072);
			}
			ss.bind(new InetSocketAddress(8000));
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}
	
	public static void checkSetPerformancePreferences() {
		try(ServerSocket ss = new ServerSocket();) {
			ss.setPerformancePreferences(2, 1, 3);	//ConnectionTime을 2로 latency를 1로, bandwidth를 3으로 설정하여 최대 대역폭이 가장 중요하고, 최소 지연이 가장 덜 중요하고, 연결 시간이 중간임을 세팅한다.
			ss.bind(new InetSocketAddress(8000));
		} catch (IOException e1) {
			System.err.println(e1);
		}
	}
}
