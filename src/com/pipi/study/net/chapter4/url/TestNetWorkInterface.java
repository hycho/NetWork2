package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class TestNetWorkInterface {
	
	public static void main(String[] args) throws Exception {
		/**
		 * NetworkInterface getByName(String name) : 파라메터 name이름을 가진 네트워크 인터페이스의 NetworkInterface객체를 리턴하며 없을 경우 null을 리턴한다. 만약 찾다 오류나면 SocketException을 발생한다.
		 * NetworkInterface getByInetAddress(InetAddress address) : 파라메터 InetAddress가 가르키는 IP 주소와 관련있는 NetworkInterface객체를 리턴한다.
		 * Enumeration getNetworkInterfaces() : 로컬 호스트의 네트워크 인터페이스 전체를 Enum으로 리턴한다.
		 */
		
		NetworkInterface ni = NetworkInterface.getByName("eth0");
		if(ni != null) {
			System.out.println("eth is " + ni.getDisplayName());
		} else {
			System.out.println("No such interface eth0(eth0를 찾을수 없다)");
		}
		
		System.out.println("");
		
		InetAddress localIa = InetAddress.getByName("127.0.0.1");
		NetworkInterface ni2 = NetworkInterface.getByInetAddress(localIa);	//loop-back 주소와 관련있는 NetworkInterface를 반환한다.
		if(ni2 != null) {
			System.out.println("127.0.0.1 is " + ni2.getDisplayName());
		} else {
			System.out.println("No such interface 127.0.0.1");
		}
		
		System.out.println("");
		
		Enumeration<NetworkInterface> erNi =  NetworkInterface.getNetworkInterfaces();
		while(erNi.hasMoreElements()) {	//간단하게 로컬 호스트의 모든 네트워크 인터페이스를 보여준다.
			NetworkInterface inNi = erNi.nextElement();
			System.out.println(inNi);
		}
	}
	
}
