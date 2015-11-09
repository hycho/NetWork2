package com.pipi.study.net.chapter8.httpserver1;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class JHTTP {
	private static final Logger logger = Logger.getLogger(JHTTP.class.getName());
	private static final int NUM_THREADS = 50;
	private static final String INDEX_FILe = "index.html";
	
	private final File rootDirectory;
	private final int port;
	
	public JHTTP(File rootDirectory, int port) throws IOException{
		if(!rootDirectory.isDirectory()) {
			throw new IOException(rootDirectory + " does not exist as a directory");
		}
		this.rootDirectory = rootDirectory;
		this.port = port;
	}
	
	public void start() {
		ExecutorService es = Executors.newFixedThreadPool(NUM_THREADS);
		try(ServerSocket ss = new ServerSocket(port)) {
			while(true) {
				Socket request = ss.accept();
				es.submit(new RequestProcessor(rootDirectory, "index.html", request));
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		String documentRoot = "C:/DocumentRoot";
		int port = 80;
		
		JHTTP server;
		try {
			server = new JHTTP(new File(documentRoot), port);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
