package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetWorkInterfaceExam {
	
	public static void main(String[] args) throws Exception {
		/**
		 * Enumeration getInetAddresses() : NetworkInterface가 연결된 각각의 Ip주소를 위한 InetAddress 객체둘를 포함한 Enumeration을 반환한다.
		 * String getName : eth0이나 lo같은 NetworkInterface 객체의 이름을 반환한다.
		 * String getDisplayName() : eth0, lo가 아닌 NetworkInterface에 대해서 더 좀더 이해하기 쉬운 방식의 이름을 리턴한다. 유닉스에서는 getName과 비슷하지만 윈도우에선 이쁜 이름을 리턴한다.
		 */
		
		NetworkInterface ni = NetworkInterface.getByName("lo");	//local loop-back interface
		Enumeration<InetAddress> addres = ni.getInetAddresses();
		while(addres.hasMoreElements()) { //loopback과 연결된 ip를 위한 InetAddress를 표시한다.
			System.out.println(addres.nextElement());
		}
		
		System.out.println();
		
		System.out.println("Name is " + ni.getName());
		
		System.out.println();
		
		System.out.println("DisplayName is " + ni.getDisplayName());
		
	}
	
}
