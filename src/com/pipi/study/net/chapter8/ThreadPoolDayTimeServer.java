package com.pipi.study.net.chapter8;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDayTimeServer {
	
	public static int PORT = 13;
	public static int POOLSIZE = 50;
	
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(POOLSIZE);
		
		
		try(ServerSocket server = new ServerSocket(PORT)) {
			while(true) {
				try{
					Socket conn = server.accept();
					Callable<Void> task = new DayTimeThread(conn);
					pool.submit(task);
				} catch(Exception e) {}
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	private static class DayTimeThread implements Callable<Void> {
		private Socket conn;
		
		public DayTimeThread(Socket conn) {
			this.conn = conn;
		}
		
		@Override
		public Void call() throws Exception {
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
			
			return null;
		}
	}
}
