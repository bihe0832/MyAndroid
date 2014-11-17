package com.bihe0832.common;

import java.io.File;

import android.os.Environment;

/**
 * 文件管理通用�?
 * @author zixie
 *
 */
public class FileUtils {
	//项目文件夹（sdcard�?
    private static final String DIR_EXT_MAIN = "temp";
    /**
     * Check to see whether external storage(sdcard) existed at present.
     */
    public static boolean hasExternalStorage() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 获得SDK存储目录
     * 
     * @return
     */
    public static File getExternalRootDir() {
        File childDir = null;
        // Environment.getExternalStorageDirectory() 返回/sdcard/
        // 使用系统方法，避免这个名字可能不�?
        childDir = new File(Environment.getExternalStorageDirectory(), DIR_EXT_MAIN);
        if (!childDir.exists()){
            childDir.mkdirs();
        }
        return childDir;
    }
}
