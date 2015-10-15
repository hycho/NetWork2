package com.pipi.study.net.chapter4.url;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckAddressType {

	public static void main(String[] args) throws UnknownHostException {
		/**
		 * 주소 타입
		 * boolean isAnyLocalAddress() : InetAddress가 가르키는 주소가 와일드 카드 주소인경우 true 아닐 경우 false를 리턴
		 * boolean isLoopbackAddress() : InetAddress가 가르키는 주소가 루프백 주소일 경우 true 아닐 경우 false를 리턴
		 * boolean isLinkLocalAddress() : InetAddress가 가르키는 주소가 Ipv6 링크 로컬 주소일 경우 true 아닐 경우 false를 리턴 (사이트보다 작은범위)
		 * boolean isSiteLocalAddress() : InetAddress가 가르키는 주소가 Ipv6 사이트 로컬 주소일 경우 true 아닐 경우 false를 리턴 (링크보다 큰범위 글로벌보다 작은 범위)
		 * boolean isMulticastAddress() : InetAddress가 가르키는 주소가 멀티캐스트 주소일 경우 true 아닐 경우 false를 리턴
		 * boolean isMCGlobal() : InetAddress가 가르키는 주소가 글로벌 멀티캐스트 주소일 경우 true 아닐 경우 false를 리턴
		 * boolean isMCNodeLocal() : 인터페이스 로컬 멀티 캐스트 주소일 경우 true 아닐 경우 false를 반환한다.
		 * boolean isMCLinkLocal() : InetAddress가 가르키는 주소가 링크 범위의 멀티캐스트 주소일 경우 true 아닐 경우 false를 리턴
		 * boolean isMCSiteLocal() : InetAddress가 가르키는 주소가 사이트 범위의 멀티캐스트 주소일 경우 true 아닐 경우 false를 리턴
		 * boolean isMCOrgLocal() : InetAddress가 가르키는 주소가 조직 또는 단체 범위 멀티캐스트 주소일 경우 true 아닐 경우 false를 리턴
		 */
		InetAddress inetAddr = InetAddress.getLocalHost();
		
		if(inetAddr.isAnyLocalAddress()) {
			System.out.println(inetAddr + "는 와일드 카드 address.");
		}
		
		if(inetAddr.isLoopbackAddress()) {
			System.out.println(inetAddr + "는 루프백 address.");
		}
		
		if(inetAddr.isLinkLocalAddress()) {
			System.out.println(inetAddr + "는 링크 로컬 address.");
		} else if (inetAddr.isSiteLocalAddress()) {
			System.out.println(inetAddr + "는 사이트 로컬 address.");
		} else {
			System.out.println(inetAddr + "는 글로벌 address.");
		}
		
		if(inetAddr.isMulticastAddress()) {
			if(inetAddr.isMCGlobal()) {
				System.out.println(inetAddr + "는 글로벌 멀티 캐스트 address.");
			} else if(inetAddr.isMCOrgLocal()) {
				System.out.println(inetAddr + "는 조직 단체 범위 멀티 캐스트 address.");
			} else if(inetAddr.isMCSiteLocal()) {
				System.out.println(inetAddr + "는 사이트 범위 멀티 캐스트 address.");
			} else if(inetAddr.isMCLinkLocal()) {
				System.out.println(inetAddr + "는 링크 범위 멀티 캐스트 address.");
			} else if(inetAddr.isMCNodeLocal()) {
				System.out.println(inetAddr + "는 로컬 범위 멀티 캐스트 address.");
			} else {
				System.out.println(inetAddr + "는 알 수 없는 멀티캐스트 address.");
			}
		} else {
			System.out.println(inetAddr + "는 유니캐스트 address.");
		}
		
		Inet6Address i6;
	}

}
