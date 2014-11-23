package com.bihe0832.urldemo;

import android.app.Activity;
import android.os.Bundle;

import com.example.com.bihe0832.urldemo.R;

public class UrlDemoActiviy extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_url_demo);
		UrlDemo.test();
	}
}
