package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class WarmMultiThreadDayTimeServer {
	
	public static int PORT = 13;
	
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)) {
			while(true) {
				try{
					Socket conn = server.accept();
					Thread task = new DayTimeThread(conn);
					task.start();
				} catch(Exception e) {}
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	private static class DayTimeThread extends Thread {
		private Socket conn;
		
		public DayTimeThread(Socket conn) {
			this.conn = conn;
		}
		
		@Override
		public void run() {
			try {
				Writer out = new OutputStreamWriter(conn.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + "\r\n");
				out.flush();
			} catch(IOException e) {
				System.err.println(e);
			} finally {
				try{
					conn.close();
				} catch (IOException e) {}
			}
		}
	}
}
