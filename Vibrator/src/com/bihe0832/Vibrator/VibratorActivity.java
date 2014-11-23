package com.bihe0832.vibrator;

import com.bihe0832.mydemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class VibratorActivity extends Activity {

	public static final String TAG = "MyDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//UrlDemo.test();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
