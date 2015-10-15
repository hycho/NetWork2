package com.pipi.study.net.chapter6.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class FileCacheRequest extends CacheRequest{
	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Override
	public OutputStream getBody() throws IOException {
		return out;
	}

	@Override
	public void abort() {
		out.reset();
	}
	
	public byte[] getData() {
		if(out.size() == 0) {
			return null;
		} else {
			return out.toByteArray();
		}
	}
	
}
