package com.bihe0832.urldemo;

import com.example.com.bihe0832.urldemo.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UrlDemoActiviy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_url_demo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.url_demo, menu);
		return true;
	}

}
