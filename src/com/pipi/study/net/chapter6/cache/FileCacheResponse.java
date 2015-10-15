package com.pipi.study.net.chapter6.cache;

import java.io.IOException;
import java.io.InputStream;
import java.net.CacheResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FileCacheResponse extends CacheResponse {
	
	private final Map<String, List<String>> headers;
	private final FileCacheRequest request;
	private final Date expires;
	private final CacheControl control;

	public FileCacheResponse(Map<String, List<String>> headers, FileCacheRequest request, Date expires,
			CacheControl control) {
		super();
		this.headers = headers;
		this.request = request;
		this.expires = expires;
		this.control = control;
	}

	@Override
	public Map<String, List<String>> getHeaders() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getBody() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
