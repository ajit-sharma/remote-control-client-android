package com.exromany.app.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.exromany.app.controller.RepeatListener;

public class MainActivity extends Activity {

	public TextView log;
	public HttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		log = (TextView) findViewById(R.id.textLog);
		client = new HttpClient();		
		
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
					client.key(key);
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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	    switch (item.getItemId()) 
		{
	    case R.id.launch:
			Intent intent = new Intent(MainActivity.this, LaunchActivity.class);
			startActivity(intent);
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

}
