package com.bihe0832.logcat.farmwork;

import java.io.File;
import java.io.IOException;

import com.bihe0832.common.Logger;
import com.bihe0832.common.Shell;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LogcatService extends Service {  
  
    private MyBinder myBinder = new MyBinder();  
      
    @Override  
    public IBinder onBind(Intent intent) { 
    	Logger.d("LogcatService onBind");
    	startLog();
        return myBinder;  
    }  
      
    public class MyBinder extends Binder{  
          
        public LogcatService getService1(){  
            return LogcatService.this;  
        }  
    }  
    
  
    @Override  
    public void onCreate() {  
    	super.onCreate();  
    	Logger.d("LogcatService onCreate");
    }  
  
    @Override  
    public void onStart(Intent intent, int startId) {  
        super.onStart(intent, startId);  
        Logger.d("LogcatService onStart");
    }  
  
    @Override  
    public void onDestroy() {  
    	super.onDestroy();  
    	Logger.d("LogcatService onDestroy");
    }  
  
    @Override  
    public boolean onUnbind(Intent intent) {  
       boolean unbindFlag = super.onUnbind(intent);  
       Logger.d("LogcatService onUnbind");
       stopLog();
       return unbindFlag;
    }  
      
    private void stopLog() {
    	Logger.d("LogcatService stopLog");
	}

	public void startLog(){
		Logger.d("LogcatService startLog");
    	File tempFile = new File("/storage/sdcard0/logcat.log");
    	if(!tempFile.exists()){
    		try {
    			tempFile.createNewFile();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	Shell.execShell("logcat -v time > " + tempFile.toString());
    }
}  