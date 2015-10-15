package com.pipi.study.net.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class EqualAndHash {

	public static void main(String[] args) {
		try {
			URL naverUrl = new URL("http://naver.com");
			URL wwwnaverUrl = new URL("http://www.naver.com");
			URL wwwnaverUrl80 = new URL("http://www.naver.com/index.html");
			
			if(naverUrl.equals(wwwnaverUrl)) {
				System.out.println("naverUrl�� wwwnaverUrl�� ����");
			} else {
				System.out.println("naverUrl�� wwwnaverUrl�� Ʋ��");
			}
			
			if(wwwnaverUrl.equals(wwwnaverUrl80)) {
				System.out.println("naverUrl�� naverUrl80�� ����");
			} else {
				System.out.println("naverUrl�� naverUrl80�� Ʋ��");
			}
			
			System.out.println("naverUrl = " + naverUrl.hashCode());
			System.out.println("wwwnaverUrl = " + wwwnaverUrl.hashCode());
			System.out.println("wwwnaverUrl80 = " + wwwnaverUrl80.hashCode());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
