package com.pipi.study.net.chapter8.httpserver1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class RequestProcessor implements Callable<Void>{

	private final static Logger logger = Logger.getLogger(RequestProcessor.class.getName());	//로그 인스턴스 생성
	
	private File rootDirectory;
	private String indexFileName = "index.html";
	private Socket connection;
	
	public RequestProcessor(File rootDirectory, String indexFileName, Socket connection) {
		if(rootDirectory.isFile()) {
			throw new IllegalArgumentException("최상위 루트 디렉토리는 반드시 폴더이야만 합니다.");
		}
		
		try {
			rootDirectory = rootDirectory.getCanonicalFile();
		} catch(IOException e) {}
		
		this.rootDirectory = rootDirectory;
		
		if(indexFileName != null) {
			this.indexFileName = indexFileName;
		}
		
		this.connection = connection;
	}
	
	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		String root = rootDirectory.getPath();
		
		try {
			OutputStream raw = new BufferedOutputStream(connection.getOutputStream());
			Writer out = new OutputStreamWriter(raw);
			Reader in = new InputStreamReader(new BufferedInputStream(connection.getInputStream()), "US-ASCII");
			
			StringBuilder requestLine = new StringBuilder();
			
			while(true) {
				int c = in.read();
				if(c == '\r' || c == '\n' || c == -1) {
					break;
				}
				requestLine.append((char) c);
			}
			
			String get = requestLine.toString();
			String[] tokens = get.split("\\s+");	//[0] = Method(Get), [1] = Path(/kkk), [2] = protocalVersion(HTTP/1.1)
			String method = tokens[0];
			String version = "";
			
			if(tokens.length > 2) {
				version = tokens[2];
			}
			
			if("GET".equals(method)) {
				String fileName = tokens[1];
				
				if(fileName.endsWith("/")) {
					fileName += indexFileName;
				}
				
				File readFile = new File(rootDirectory, fileName.substring(1, fileName.length()));
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(tokens[1]);
				
				if(readFile.canRead() && readFile.getCanonicalPath().startsWith(root)) { //설정한 Document외부로 접근을 못하도록 한다.
					byte[] bFile = Files.readAllBytes(readFile.toPath());
					if(version.startsWith("HTTP/")) {
						sendHeader(out, "HTTP/1.0 200 OK", contentType, bFile.length);
					}
					raw.write(bFile);
					raw.flush();
				} else {	//찾는 파일이 없을 경우
					String body = new StringBuilder("<HTML>\r\n")
							.append("<HEAD>\r\n")
							.append("<TITLE>File Not Found</TITLE>\r\n")
							.append("</HEAD>\r\n")
							.append("<BODY>\r\n")
							.append("<H1>Error 404: File Not Found</H1>\r\n")
							.append("</BODY></HTML>\r\n").toString();
					// HTTP1.0이상 지원일경우 Header를 먼저 보내준다.
					if(version.startsWith("HTTP/")) {
						sendHeader(out, "HTTP/1.0 404 File Not Found", "text/html", body.length());
					}
					out.write(body);
					out.flush();
				}
			} else {	//GET이 아닐경우 지원 불가능한 페이지 header,body를 전송한다.
				String body = new StringBuilder("<HTML>\r\n")
						.append("<HEAD>\r\n")
						.append("<TITLE>Not Implemented</TITLE>\r\n")
						.append("</HEAD>\r\n")
						.append("<BODY>\r\n")
						.append("<H1>Error 501: Not Implemented</H1>\r\n")
						.append("</BODY></HTML>\r\n").toString();
				// HTTP1.0이상 지원일경우 Header를 먼저 보내준다.
				if(version.startsWith("HTTP/")) {
					sendHeader(out, "HTTP/1.0 501 Not Implemented", "text/html", body.length());
				}
				out.write(body);
				out.flush();
			}
			
		} catch(IOException e) {
			
		}
		
		return null;
	}
	
	private void sendHeader(Writer out, String responseCode, String contentType, int length) throws IOException {
		out.write(responseCode + "\r\n");
		Date now = new Date();
		out.write("Date: " + now + "\r\n");
		out.write("Server: JHTTP 2.0\r\n");
		out.write("Content-length: " + length + "\r\n");
		out.write("Content-type: " + contentType + "\r\n\r\n"); //header와 body는 \r\n으로 분리가 되어있기에 2번 호출함.
		out.flush();
	}
}
