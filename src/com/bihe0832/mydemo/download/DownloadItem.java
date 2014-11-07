package com.bihe0832.mydemo.download;

import java.net.URL;

/**
 * 下载文件的结构体，包含url，文件大小，hash值，本地保存路径和下载进度
 * @author hardyshi
 *
 */
class DownloadItem{
	// 下载进度
	public float mPercent = 0;
	// 下载路径
	public URL mFileUrl;
	// 要下载文件的hash值
	public String mHashValue;
	// 下载的文件大小
	public long mFileLength;
	// 文件的保存路径
	public String mLocalFilePath;
	public DownloadItem(URL url, String filePath,String hashValue) {
		this.mFileUrl = url;
		this.mLocalFilePath = filePath;
		this.mHashValue = hashValue;
	}
	public DownloadItem() {
	}
}