package com.exromany.app.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class LaunchActivity extends Activity {

	public TextView log;
	public HttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);

		log = (TextView) findViewById(R.id.textLog);
		client = new HttpClient();
		
		final ArrayList<String> buttonsList = new ArrayList<String>();
		buttonsList.add("button21");
		buttonsList.add("button22");
		buttonsList.add("button23");
		buttonsList.add("button24");
		buttonsList.add("button25");
		buttonsList.add("button26");
		buttonsList.add("button27");
		buttonsList.add("button28");
		
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
		
		final ArrayList<String> toggleButtonsList = new ArrayList<String>();
		toggleButtonsList.add("toggleButton1");
		toggleButtonsList.add("toggleButton2");
		toggleButtonsList.add("toggleButton3");
		toggleButtonsList.add("toggleButton4");
		
		for(int i = 0; i < toggleButtonsList.size(); i++)
		{
			final String buttonName = toggleButtonsList.get(i);
			int id = getResources().getIdentifier(buttonName, "id", getPackageName());
			ToggleButton toggle = (ToggleButton) findViewById(id);
			
			toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					String key = getString(R.string.nope);
					int id = getResources().getIdentifier(buttonName, "string", getPackageName());
					key = getString(id);
			        if (isChecked) {
						client.key("00-" + key);
						log.setText(key + " pressed");
			        } else {
						client.key("99-" + key);
						log.setText(key + "released");
			        }
			    }
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_launch, menu);
		return true;
	}

}
