package com.bihe0832.Vibrator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class VibratorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vibrator);
	}
	
	public void startVibratorOnce(View v) {
		VibratorUtil.Vibrate(this, 100);
	}
	
	public void startVibrator(View v) {
		// 第二个参数是节奏数组，理解为延迟、振动时长，延时，振动时长
		VibratorUtil.Vibrate(this, new long[] { 50, 200, 100, 300 }, false); 
	}
}
