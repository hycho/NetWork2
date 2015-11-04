package com.pipi.study.net.chapter8.httpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class SingleFileHTTPServer {
	private static final Logger logger = Logger.getLogger(SingleFileHTTPServer.class);
	private final byte[] content;
	private final byte[] header;
	private final int port;
	private final String encoding;
	
	public SingleFileHTTPServer(String data, String encoding, String mimeType, int port) throws UnsupportedEncodingException {
		this(data.getBytes(encoding), encoding, mimeType, port);
	}
	
	public SingleFileHTTPServer(byte[] data, String encoding, String mimeType, int port) {
		this.content = data;
		this.port = port;
		this.encoding = encoding;
		String header = "HTTP/1.0 200 OK\r\n"
				+ "Server: OneFile 2.0\r\n"
				+ "Content-length: " + this.content.length + "\r\n"
				+ "Content-type:" + mimeType + "; charset=" + encoding + "\r\n\r\n";
		this.header = header.getBytes(Charset.forName("US-ASCII"));
	}
	
	public void start() {
		ExecutorService pool = Executors.newFixedThreadPool(100);
		try(ServerSocket server = new ServerSocket(this.port)){
			logger.info(server.getLocalPort() +"포트에 연결을 받기 위한 준비중...");
			
			while(true) {
				try{
					Socket connection = server.accept();
					pool.submit(new HTTPHandlr(connection));
				} catch(IOException e) {
					logger.log(Level.WARNING, "Accept 실패했습니다!!!", e);
				} catch(RuntimeException e) {
					logger.log(Level.WARNING, "런타임 오류 발생했습니다!!!", e);
				}
			}
		} catch(IOException e) {
			logger.log(Level.WARNING, "서버가 기동 되지 않았습니다!!!");
		}
	}
	
	private class HTTPHandlr implements Callable<Void> {
		private final Socket connection;
		
		HTTPHandlr(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() throws Exception {
			try{
				OutputStream out = new BufferedOutputStream(connection.getOutputStream());
				InputStream in = new BufferedInputStream(connection.getInputStream());
				
				// 요청의 첫번째 줄만 읽어 들인다. 1번째 줄만 필요하니까.
				StringBuilder request = new StringBuilder(80);
				while(true) {
					int c = in.read();
					if(c == '\r' || c == '\n' || c == -1) {
						break;
					}
					request.append((char) c);
					
					// 1라인의 정보를 사용해서 HTTP/1.0이나 그 이후 버전을 지원할 경우 MIME 헤더를 전송한다.
					if(request.toString().indexOf("HTTP/") != -1) {
						out.write(header);
					}
					
					out.write(content);
					out.flush();
				}
			} catch(IOException e) {
				logger.log(Level.WARNING, "Error writing to client", e);
			} finally {
				logger.info("연결 종료");
				connection.close();
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		logger.info("서버 기동 준비.");
		int port = 80;
		String encoding = "UTF-8";
		String filePath = "C:/temp/PV3.txt";
		
		try{
			Path path = Paths.get(filePath);
			byte[] data = Files.readAllBytes(path);
			
			String contentType = URLConnection.getFileNameMap().getContentTypeFor(filePath);
			SingleFileHTTPServer server = new SingleFileHTTPServer(data, encoding, contentType, port);
			server.start();
			
		} catch(IOException e) {
			logger.severe(e.getMessage());
		}
	}
}
