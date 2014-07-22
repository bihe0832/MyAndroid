package com.bihe0832.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	public static final String TAG = "MyDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//UrlDemo.test();
		
		String originalSig = "4578e54fb3a1bd18e0681bc1c734514e";
		Log.i(TAG, "originalSig:"+originalSig); 
		Log.i(TAG, "my      md5 :"+com.bihe0832.mydemo.IntToHexStr.IntToHexStr.myMD5(originalSig)); 
		Log.i(TAG, "goddess md5 :"+com.bihe0832.mydemo.IntToHexStr.IntToHexStr.goddessMD5(originalSig)); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
