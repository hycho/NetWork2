package com.pipi.study.net.chapter7.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayTimeToDate {

	public static void main(String[] args) {
		String hostname = "time.nist.gov";
		
		
		try (Socket socket = new Socket(hostname, 13);) {
			socket.setSoTimeout(15000); //만약 15초동안 아무런 연결을 하지 못할 경우 SocketTimeoutException 예외를 발생시킨다.
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in);
			for(int c = reader.read(); c!=-1; c=reader.read()) {
				time.append((char) c);
			}
			System.out.println(parseDate(time.toString()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static Date parseDate(String strDate) throws ParseException{
		String[] arrDate = strDate.split(" ");
		String dateTime = arrDate[1] + " " +arrDate[2] + "UTC";
		DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
		
		return format.parse(dateTime);
	}
}
