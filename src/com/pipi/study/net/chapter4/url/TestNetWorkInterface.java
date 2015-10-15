package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class TestNetWorkInterface {
	
	public static void main(String[] args) throws Exception {
		/**
		 * NetworkInterface getByName(String name) : �Ķ���� name�̸��� ���� ��Ʈ��ũ �������̽��� NetworkInterface��ü�� �����ϸ� ���� ��� null�� �����Ѵ�. ���� ã�� �������� SocketException�� �߻��Ѵ�.
		 * NetworkInterface getByInetAddress(InetAddress address) : �Ķ���� InetAddress�� ����Ű�� IP �ּҿ� �����ִ� NetworkInterface��ü�� �����Ѵ�.
		 * Enumeration getNetworkInterfaces() : ���� ȣ��Ʈ�� ��Ʈ��ũ �������̽� ��ü�� Enum���� �����Ѵ�.
		 */
		
		NetworkInterface ni = NetworkInterface.getByName("eth0");
		if(ni != null) {
			System.out.println("eth is " + ni.getDisplayName());
		} else {
			System.out.println("No such interface eth0(eth0�� ã���� ����)");
		}
		
		System.out.println("");
		
		InetAddress localIa = InetAddress.getByName("127.0.0.1");
		NetworkInterface ni2 = NetworkInterface.getByInetAddress(localIa);	//loop-back �ּҿ� �����ִ� NetworkInterface�� ��ȯ�Ѵ�.
		if(ni2 != null) {
			System.out.println("127.0.0.1 is " + ni2.getDisplayName());
		} else {
			System.out.println("No such interface 127.0.0.1");
		}
		
		System.out.println("");
		
		Enumeration<NetworkInterface> erNi =  NetworkInterface.getNetworkInterfaces();
		while(erNi.hasMoreElements()) {	//�����ϰ� ���� ȣ��Ʈ�� ��� ��Ʈ��ũ �������̽��� �����ش�.
			NetworkInterface inNi = erNi.nextElement();
			System.out.println(inNi);
		}
	}
	
}
