package com.pipi.study.net.chapter6;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileAndSaveFile {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://img.naver.net/static/www/u/2013/0731/nmms_224940510.gif");
			URLConnection uconn = url.openConnection();
			String contentType = uconn.getContentType();
			int contentLength = uconn.getContentLength();	// �������� Byte���� ����� �����Ѵ�. ���� int�ִ�ġ�� �Ѿ�� -1�� ���ϵȴ� (2.1gb)
			
			if(contentType.startsWith("text/") || contentLength == -1) {
				throw new IOException("���̳ʸ� ������ �ƴϴ� ����.");
			}
			
			try(InputStream raw = uconn.getInputStream()) {
				InputStream in = new BufferedInputStream(raw);
				byte[] data = new byte[contentLength];
				int offset = 0;
				
				while(offset < contentLength) {
					int bytesRead = in.read(data, offset, data.length - offset);
					if(bytesRead == -1) {
						break;
					}
					offset += bytesRead;
				}
				
				if(offset != contentLength) {
					throw new IOException("������ ���ҽ� ������� ���� �о�帰 ����� Ʋ���� ����! ���� ������ ������ = "+offset+", ���� ���ҽ� ������ = "+contentLength);
				}
				
				String filename = url.getFile();
				filename = "D:/temp/"+filename.substring(filename.lastIndexOf('/') + 1);
				try(FileOutputStream fOut = new FileOutputStream(filename)) {
					fOut.write(data);
					fOut.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
