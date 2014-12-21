package com.bihe0832.download;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;

import com.bihe0832.common.FileUtils;

public class DownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		File childDir = FileUtils.getExternalRootDir();
		try {
			DownloadThread.addToDownloadQueue(
					new URL("http://ossweb-img.qq.com/upload/msdk_img/201408/1407779503010515015.jpg"), 
					childDir.toString()+"temp1.png", 
					"63c5f6b6a63fb8e99b6c94ed1b8ac7aa");
			DownloadThread.addToDownloadQueue(
					new URL("http://ossweb-img.qq.com/upload/msdk_img/201408/1407779496538710095.jpg"), 
					childDir.toString()+"temp2.png", 
					"21494b60273505fb116997c3af3155b9");
			DownloadThread.addToDownloadQueue(
					new URL("http://img.msdk.qq.com/notice/1396/20140820201609_1080X440.png"), 
					childDir.toString()+"temp3.png", 
					"9da85dfffb46ffe4393aaeea3f0319fd");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
