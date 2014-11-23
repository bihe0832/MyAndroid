package com.bihe0832.Vibrator;

import android.app.Activity;
import android.os.Bundle;

public class VibratorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vibrator);
		VibratorUtil.Vibrate(this, 100);
		
		// 第二个参数是节奏数组，理解为延迟、振动时长，延时，振动时长
		VibratorUtil.Vibrate(this, new long[] { 50, 200, 100, 300 }, false); 
	}
}
