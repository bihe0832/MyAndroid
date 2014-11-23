package com.bihe0832.download;

import android.app.Activity;
import android.os.Bundle;

public class DownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		// TODO 找个MSDK的日志
		DownloadThread.addToDownloadQueue(null, null, null);
		DownloadThread.addToDownloadQueue(null, null, null);
		DownloadThread.addToDownloadQueue(null, null, null);
		DownloadThread.addToDownloadQueue(null, null, null);
	}

}
