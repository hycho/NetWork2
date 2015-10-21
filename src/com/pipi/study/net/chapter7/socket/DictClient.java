package com.pipi.study.net.chapter7.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class DictClient {

	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;
	
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			// 1. 소켓 생성
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			
			// 2. 서버에 데이터를 전송할 Writer 생성
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out);
			writer = new BufferedWriter(writer);
			
			//3. 서버에서 데이터를 응답받기 위한 Reader생성
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			// 한라인씩 서버로 내용을 보내고, 서버로부터 응답을 한 라인씩 읽기 위해 기다리고 읽어서 출력한다.
			behive("gold", writer, reader);
			System.out.println("");
			behive("pc", writer, reader);
			System.out.println("");
			behive("love", writer, reader);
			
			writer.write("quit\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
	
	public static void behive(String word, Writer writer, BufferedReader reader) throws IOException {
		//서버에 데이터를 쓴다.
		writer.write("DEFINE fd-eng-lat " + word + "\r\n");
		writer.flush();
		
		for(String line = reader.readLine(); line != null; line = reader.readLine()) {
			// 보고 싶지 않은 불필요한 정보는 지나간다.
			if(line.startsWith("250 ")) { // 이상없이 종료시
				return;
			} else if(line.startsWith("552 ")) { // 매칭 되는 데이터 없이 종료시
				System.out.println("No definition found for " + word);
				return;
			} else if(line.matches("\\d\\d\\d .*")) { // 숫자3개로 시작하는 모든 항목은 지나감
				continue;
			} else if(line.trim().equals(".")) { //.하나만 있는 케이스도 지나감
				continue;
			} else {
				System.out.println(line);
			}
		}
	}

}
