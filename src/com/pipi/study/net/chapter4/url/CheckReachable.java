package com.pipi.study.net.chapter4.url;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class CheckReachable {

	public static void main(String[] args) throws IOException {
		/**
		 * boolean isReachable(int timeout)
		 * boolean isReachable(NetworkInterface interface, int ttl, int timeout) 
		 */
		
		InetAddress inetAddr = InetAddress.getByName("naver.com");
		
		if(inetAddr.isReachable(3000)){
			System.out.println("접근 가능");
		} else {
			System.out.println("접근 불가");
		}
		
		Enumeration<NetworkInterface> nienum = NetworkInterface.getNetworkInterfaces();
		
        while (nienum.hasMoreElements()) {
            NetworkInterface ni = nienum.nextElement();
    		System.out.println(inetAddr.isReachable(ni, 10, 3000));
        }
	}

}
