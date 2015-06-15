package com.bihe0832.logcat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.bihe0832.common.Logger;
import com.bihe0832.logcat.farmwork.LogcatService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button startLogBtn = (Button)  findViewById(R.id.btn_log_start); 
		startLogBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,LogcatService.class);  
		        bindService(intent, conn, Context.BIND_AUTO_CREATE); 
			}
		});
		
		Button stopLogBtn = (Button)  findViewById(R.id.btn_log_stop); 
		stopLogBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				unbindService(conn);
			}
		});
		
	}

	@Override
	protected void onStart(){
		super.onStart();
		
	}
	
	private ServiceConnection conn = new ServiceConnection() {  

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
 			Logger.d("onServiceConnected");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Logger.d("onServiceDisconnected");
		}  
    };  
	
}
