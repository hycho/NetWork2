package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckSpamBySpamhous {
	
	/**
	 * sbl.spamhous.org���񽺿��� 1.2.3.4�� ���и����� Ȯ���ϴ� ����� 4.3.2.1.sbl.spamhaus.org�� ȣ���غ���ȴ�. ȣ���ؼ� 127.0.0.2�� ���ϵǴ� ��� 1.2.3.4�� ���и��̴�.
	 */
	public static final String BLACKHOLESITE = "sbl.spamhaus.org";
	
	public static void main(String[] args) {
		/**
		 * sbl.spamhaus.org�� ����Ͽ� spamüũ�� �Ѵ�.
		 */
		String host = "185.117.72.158"; //spamIP
		
		if(isSpam(host)) {
			System.out.println(host + " �� ���� IP�Դϴ�.");
		} else {
			System.out.println(host + " �� ���� IP �ּҰ� �ƴմϴ�.");
		}
		
	}
	
	private static boolean isSpam(String host) {
		try {
			InetAddress ia = InetAddress.getByName(host);
			byte[] quad = ia.getAddress();
			String query = BLACKHOLESITE;
			
			for(byte octet : quad) {
				int uByte = octet < 0 ? octet + 256 : octet;
				query = uByte + "." + query;
			}

			InetAddress.getByName(query);

			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}

}
