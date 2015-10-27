package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {

	public final static int DAYPORT = 13;
	
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(DAYPORT);) {
			while(true) {
				Socket conn = server.accept();
				OutputStream out = conn.getOutputStream();
				Writer writer = new OutputStreamWriter(out);
				
				Date now = new Date();
				writer.write(now.toString() + "\r\n"); //라인을 끝내기위한 캐리지리턴/라인피드를 이 코드처럼 명확하게 해야한다. System.getProperty("line.separator")나 println()같은 시스템 라인 구분자는 사용하면 안된다.
				writer.flush();
				conn.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
