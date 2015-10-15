package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MethodOfGet {

	public static void main(String[] args) throws UnknownHostException {
		/**
		 * String getHostName() : InetAddress가 바라보는 IP에 해당하는 hostname을 문자열로 리턴 한다. 
		 * String getCanonicalHostName : InetAddress가 바라보는 IP에 해당하는 hostname을 문자열로 리턴 한다. (무조건 DNS에 정보 요청)
		 * String getHostAddress() : InetAddress가 바라보는 IP주소를 마침표(".")로 구분된 형식의 문자열을 리턴 한다.
		 * byte[] getAddress() : 부호없는 바이트 배열로 IP 주소를 리턴한다. java는 기본 데이터 타입으로 부호 없는 바이트를 제공하지 않기때문에 127이상 값은 음수로 표시를 한다. 음수 값을 고려해서 값을 변환 해야한다. 
		*/
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println("getHostName = " + ia.getHostName());
		System.out.println("getCanonicalHostName = " + ia.getCanonicalHostName());
		System.out.println("getHostAddress = " + ia.getHostAddress());
		for(byte b : ia.getAddress()) {
			int ib = b < 0 ? b + 256 : b;	//음수일 경우 256을 더해서 양수로 만든다.
			System.out.print(ib);
			System.out.print(".");
		}
		
		System.out.println("");
		
		/**
		 * getAddress의 리턴 배열의 사이즈를 통해서 ipv4, ipv6를 구분할 수 있다
		 */
		byte[] address = ia.getAddress();
		if(address.length == 4) {
			System.out.println("Ip type = ipv4");
		} else if(address.length == 16) {
			System.out.println("Ip type = ipv6");
		} else {
			System.out.println("... What?");
		}
	}

}
