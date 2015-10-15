package com.pipi.study.net.chapter4.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckSpamBySpamhous {
	
	/**
	 * sbl.spamhous.org서비스에서 1.2.3.4가 스패머인지 확인하는 방법은 4.3.2.1.sbl.spamhaus.org를 호출해보면된다. 호출해서 127.0.0.2가 리턴되는 경우 1.2.3.4는 스패머이다.
	 */
	public static final String BLACKHOLESITE = "sbl.spamhaus.org";
	
	public static void main(String[] args) {
		/**
		 * sbl.spamhaus.org를 사용하여 spam체크를 한다.
		 */
		String host = "185.117.72.158"; //spamIP
		
		if(isSpam(host)) {
			System.out.println(host + " 은 스팸 IP입니다.");
		} else {
			System.out.println(host + " 은 스팸 IP 주소가 아닙니다.");
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
