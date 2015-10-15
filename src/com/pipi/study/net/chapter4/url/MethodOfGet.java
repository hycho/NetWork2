package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MethodOfGet {

	public static void main(String[] args) throws UnknownHostException {
		/**
		 * String getHostName() : InetAddress�� �ٶ󺸴� IP�� �ش��ϴ� hostname�� ���ڿ��� ���� �Ѵ�. 
		 * String getCanonicalHostName : InetAddress�� �ٶ󺸴� IP�� �ش��ϴ� hostname�� ���ڿ��� ���� �Ѵ�. (������ DNS�� ���� ��û)
		 * String getHostAddress() : InetAddress�� �ٶ󺸴� IP�ּҸ� ��ħǥ(".")�� ���е� ������ ���ڿ��� ���� �Ѵ�.
		 * byte[] getAddress() : ��ȣ���� ����Ʈ �迭�� IP �ּҸ� �����Ѵ�. java�� �⺻ ������ Ÿ������ ��ȣ ���� ����Ʈ�� �������� �ʱ⶧���� 127�̻� ���� ������ ǥ�ø� �Ѵ�. ���� ���� ����ؼ� ���� ��ȯ �ؾ��Ѵ�. 
		*/
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println("getHostName = " + ia.getHostName());
		System.out.println("getCanonicalHostName = " + ia.getCanonicalHostName());
		System.out.println("getHostAddress = " + ia.getHostAddress());
		for(byte b : ia.getAddress()) {
			int ib = b < 0 ? b + 256 : b;	//������ ��� 256�� ���ؼ� ����� �����.
			System.out.print(ib);
			System.out.print(".");
		}
		
		System.out.println("");
		
		/**
		 * getAddress�� ���� �迭�� ����� ���ؼ� ipv4, ipv6�� ������ �� �ִ�
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
