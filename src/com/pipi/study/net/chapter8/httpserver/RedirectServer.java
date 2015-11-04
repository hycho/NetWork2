package com.pipi.study.net.chapter8.httpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedirectServer {
	private static final Logger logger = Logger.getLogger(RedirectServer.class.getName());
	
	private final int port;
	private final String newSite;
	
	public RedirectServer(String newSite, int port) {
		this.port = port;
		this.newSite = newSite;
	}
	
	public void start() {
		//TODO : 개발중...
		ExecutorService pool = Executors.newFixedThreadPool(100);
		try(ServerSocket server = new ServerSocket(port)) {
			logger.info("접속 준비 중입니다.");
			
			while(true) {
				try{
					Socket connection = server.accept();
					pool.submit(new RedirectHandler(connection));
				} catch(IOException e) {
					logger.log(Level.WARNING, "Accept 실패했습니다!!!", e);
				} catch(RuntimeException e) {
					logger.log(Level.WARNING, "런타임 오류 발생했습니다!!!", e);
				}
			}
		} catch(IOException e) {
			logger.log(Level.WARNING, "서버 소켓 생성에 관해서 오류가 발생 했습니다.", e);
		}
	}
	
	private class RedirectHandler implements Callable<Void> {
		private final Socket connection;
		
		public RedirectHandler(Socket connection) {
			this.connection = connection;
		}
		
		@Override
		public Void call() throws Exception {
			logger.info("새로운 접속 클라이언트 생성.");
			Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			Reader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			//필요한 첫번째 줄만 읽는다.
			StringBuilder request = new StringBuilder(80);
			while(true) {
				int c = in.read();
				if(c == '\r' || c == '\n' || c == -1) {
					break;
				}
				request.append((char) c);
			}
			
			String get = request.toString();
			String[] pieces = get.split("\\w*");
			String theFile = pieces[1];
			
			// HTTP/1.0이나 그 이후 버전을 지원할 경우 Mime 헤더를 전송한다.
			if(get.indexOf("HTTP") != -1) {
				out.write("HTTP/1.0 302 FOUND\r\n");
				Date now = new Date();
				out.write("Date: " + now + "\r\n");
				out.write("Server: Redirector 1.1\r\n");
				out.write("Location: " + newSite + theFile + "\r\n");
				out.write("Content-type: text/html\r\n\r\n");
				out.flush();
			}
			
			// 모든 브라우저가 리다이렉션을 지원하는 것은 아니기에 해당 페이지가 어디로 이동했는지 알려주는 HTML 페이지가 필요하다.
			out.write("<HTML><HEAD><TITLE>페이지 이동 302</TITLE></HEAD>\r\n");
			out.write("<BODY><H1>302 페이지 이동</H1></BODY>\r\n");
			out.write("</HTML>");
			out.flush();
			logger.info(connection.getRemoteSocketAddress() + "클라이언트 요청 페이지 이동됨");
			return null;
		}
	}
	
	public static void main(String[] args) {
		int port = 80;
		String theSite = "http://naver.com/";
		
		if(theSite.endsWith("/")) {
			theSite = theSite.substring(0,  theSite.length() - 1);
		}
		
		RedirectServer server = new RedirectServer(theSite, port);
		server.start();
	}
}


