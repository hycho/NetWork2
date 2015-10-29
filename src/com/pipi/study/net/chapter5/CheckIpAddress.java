package com.pipi.study.net.chapter5;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckIpAddress {
	public static void main(String [] args) {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			if(ip.getHostAddress().equals("172.16.47.190")) {
				System.out.println("쿄쿄쿄");	
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
