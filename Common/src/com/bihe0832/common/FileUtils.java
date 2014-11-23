package com.bihe0832.common;


import java.io.File;

import android.os.Environment;

public class FileUtils {
    private static final String DIR_EXT_MAIN = "bihe0832";
    private static final String FILE_LOG = "bihe0832.log";

    /**
     * Check to see whether external storage(sdcard) existed at present.
     */
    public static boolean hasExternalStorage() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static File getLogFile() {
        return new File(getExternalRootDir(), FILE_LOG);
    }

    /**
     * 获得SDK存储目录
     * 
     * @return
     */
    public static File getExternalRootDir() {
        File childDir = null;
        // Environment.getExternalStorageDirectory() 返回/sdcard/
        // 使用系统方法，避免这个名字可能不同
        childDir = new File(Environment.getExternalStorageDirectory(), DIR_EXT_MAIN);
        if (!childDir.exists())
            childDir.mkdirs();

        return childDir;
    }

}
