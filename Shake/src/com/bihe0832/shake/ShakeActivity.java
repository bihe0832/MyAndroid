package com.bihe0832.shake;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.bihe0832.common.Logger;
import com.bihe0832.shake.ShakeListener.OnShakeListener;

public class ShakeActivity extends Activity {
		// 摇一摇监控的listener
		private ShakeListener mShakeListener = null;
		// 摇晃中两次触发传送摇一摇事件的时间间隔
		private static final int SHAKE_TIME_LIMIT = 800;
		//最后一次摇一摇的时间
		private long lastShakeTime = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mShakeListener = new ShakeListener(this);
		// 两次摇一摇的时间间隔
		// 现在检测时间
		mShakeListener.setOnShakeListener(new OnShakeListener() {
			public void onShake() {
				long currentUpdateTime = System.currentTimeMillis();
				long timeWaitInterval = currentUpdateTime - lastShakeTime;
				Logger.d("time:" + timeWaitInterval + " " + SHAKE_TIME_LIMIT);
				if (timeWaitInterval > SHAKE_TIME_LIMIT) {
					lastShakeTime = System.currentTimeMillis();
					Toast.makeText(ShakeActivity.this, "摇到了", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	protected void onResume() {
		super.onResume();
		if (mShakeListener != null) {
			mShakeListener.start();
		}
	}

	protected void onPause() {
		super.onPause();
		if (mShakeListener != null) {
			mShakeListener.stop();
		}
	}
}