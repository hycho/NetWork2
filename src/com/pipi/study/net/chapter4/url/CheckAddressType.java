package com.pipi.study.net.chapter4.url;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckAddressType {

	public static void main(String[] args) throws UnknownHostException {
		/**
		 * �ּ� Ÿ��
		 * boolean isAnyLocalAddress() : InetAddress�� ����Ű�� �ּҰ� ���ϵ� ī�� �ּ��ΰ�� true �ƴ� ��� false�� ����
		 * boolean isLoopbackAddress() : InetAddress�� ����Ű�� �ּҰ� ������ �ּ��� ��� true �ƴ� ��� false�� ����
		 * boolean isLinkLocalAddress() : InetAddress�� ����Ű�� �ּҰ� Ipv6 ��ũ ���� �ּ��� ��� true �ƴ� ��� false�� ���� (����Ʈ���� ��������)
		 * boolean isSiteLocalAddress() : InetAddress�� ����Ű�� �ּҰ� Ipv6 ����Ʈ ���� �ּ��� ��� true �ƴ� ��� false�� ���� (��ũ���� ū���� �۷ι����� ���� ����)
		 * boolean isMulticastAddress() : InetAddress�� ����Ű�� �ּҰ� ��Ƽĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ����
		 * boolean isMCGlobal() : InetAddress�� ����Ű�� �ּҰ� �۷ι� ��Ƽĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ����
		 * boolean isMCNodeLocal() : �������̽� ���� ��Ƽ ĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ��ȯ�Ѵ�.
		 * boolean isMCLinkLocal() : InetAddress�� ����Ű�� �ּҰ� ��ũ ������ ��Ƽĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ����
		 * boolean isMCSiteLocal() : InetAddress�� ����Ű�� �ּҰ� ����Ʈ ������ ��Ƽĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ����
		 * boolean isMCOrgLocal() : InetAddress�� ����Ű�� �ּҰ� ���� �Ǵ� ��ü ���� ��Ƽĳ��Ʈ �ּ��� ��� true �ƴ� ��� false�� ����
		 */
		InetAddress inetAddr = InetAddress.getLocalHost();
		
		if(inetAddr.isAnyLocalAddress()) {
			System.out.println(inetAddr + "�� ���ϵ� ī�� address.");
		}
		
		if(inetAddr.isLoopbackAddress()) {
			System.out.println(inetAddr + "�� ������ address.");
		}
		
		if(inetAddr.isLinkLocalAddress()) {
			System.out.println(inetAddr + "�� ��ũ ���� address.");
		} else if (inetAddr.isSiteLocalAddress()) {
			System.out.println(inetAddr + "�� ����Ʈ ���� address.");
		} else {
			System.out.println(inetAddr + "�� �۷ι� address.");
		}
		
		if(inetAddr.isMulticastAddress()) {
			if(inetAddr.isMCGlobal()) {
				System.out.println(inetAddr + "�� �۷ι� ��Ƽ ĳ��Ʈ address.");
			} else if(inetAddr.isMCOrgLocal()) {
				System.out.println(inetAddr + "�� ���� ��ü ���� ��Ƽ ĳ��Ʈ address.");
			} else if(inetAddr.isMCSiteLocal()) {
				System.out.println(inetAddr + "�� ����Ʈ ���� ��Ƽ ĳ��Ʈ address.");
			} else if(inetAddr.isMCLinkLocal()) {
				System.out.println(inetAddr + "�� ��ũ ���� ��Ƽ ĳ��Ʈ address.");
			} else if(inetAddr.isMCNodeLocal()) {
				System.out.println(inetAddr + "�� ���� ���� ��Ƽ ĳ��Ʈ address.");
			} else {
				System.out.println(inetAddr + "�� �� �� ���� ��Ƽĳ��Ʈ address.");
			}
		} else {
			System.out.println(inetAddr + "�� ����ĳ��Ʈ address.");
		}
		
		Inet6Address i6;
	}

}
