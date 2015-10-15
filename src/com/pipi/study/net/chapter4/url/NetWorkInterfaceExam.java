package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetWorkInterfaceExam {
	
	public static void main(String[] args) throws Exception {
		/**
		 * Enumeration getInetAddresses() : NetworkInterface�� ����� ������ Ip�ּҸ� ���� InetAddress ��ü�Ѹ� ������ Enumeration�� ��ȯ�Ѵ�.
		 * String getName : eth0�̳� lo���� NetworkInterface ��ü�� �̸��� ��ȯ�Ѵ�.
		 * String getDisplayName() : eth0, lo�� �ƴ� NetworkInterface�� ���ؼ� �� ���� �����ϱ� ���� ����� �̸��� �����Ѵ�. ���н������� getName�� ��������� �����쿡�� �̻� �̸��� �����Ѵ�.
		 */
		
		NetworkInterface ni = NetworkInterface.getByName("lo");	//local loop-back interface
		Enumeration<InetAddress> addres = ni.getInetAddresses();
		while(addres.hasMoreElements()) { //loopback�� ����� ip�� ���� InetAddress�� ǥ���Ѵ�.
			System.out.println(addres.nextElement());
		}
		
		System.out.println();
		
		System.out.println("Name is " + ni.getName());
		
		System.out.println();
		
		System.out.println("DisplayName is " + ni.getDisplayName());
		
	}
	
}
