package com.exromany.app.controller;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class HttpClient {

	public AsyncHttpClient client;
	public String address;

	public HttpClient() {
		address = "http://192.168.1.3:9534";
		client = new AsyncHttpClient();
	}
	
	public void key(String key) {
        client.get(address+"/key/"+key, new AsyncHttpResponseHandler());
	}

}
