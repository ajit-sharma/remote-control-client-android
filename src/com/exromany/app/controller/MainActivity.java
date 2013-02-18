package com.exromany.app.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.exromany.app.controller.RepeatListener;

import com.loopj.android.http.*;

public class MainActivity extends Activity {
	
	public String address;
	public TextView log;
	public AsyncHttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		address = "http://"+getString(R.string.address);
		log = (TextView) findViewById(R.id.textLog);
		client = new AsyncHttpClient();
		
		
		final ArrayList<String> buttonsList = new ArrayList<String>();
		buttonsList.add("button1");
		buttonsList.add("button2");
		buttonsList.add("button3");
		buttonsList.add("button4");
		buttonsList.add("button5");
		buttonsList.add("button6");
		buttonsList.add("button7");
		buttonsList.add("button8");
		buttonsList.add("button9");
		buttonsList.add("button10");
		buttonsList.add("button11");
		buttonsList.add("button12");
		
		final MainActivity main = this;
		
		for(int i = 0; i < buttonsList.size(); i++)
		{
			final String buttonName = buttonsList.get(i);
			int id = getResources().getIdentifier(buttonName, "id", getPackageName());
			Button button = (Button) findViewById(id);
			button.setOnTouchListener(new RepeatListener(800, 200, new OnClickListener() {
				@Override
				public void onClick(View view) {
					String key = getString(R.string.nope);
					int id = getResources().getIdentifier(buttonName, "string", getPackageName());
					key = getString(id);
					main.KeyHttp(key);
					log.setText(key);
				}
			}));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void KeyHttp(String key) {
		AsyncHttpClient client = new AsyncHttpClient();
        client.get(address+"/key/"+key, new AsyncHttpResponseHandler() {
//        	  @Override
//              public void onSuccess(String response) {
//                  this.log("success result");
//              }
//              
//              @Override
//              public void onStart() {
//                  this.log("starting");
//              }
//              
//              @Override 
//              public void onFailure(Throwable error) {
//                  this.log("failure result");
//              }
//              
//              public void log(String text) {
//                  log.setText(text);
//              }
        });
	}

}
