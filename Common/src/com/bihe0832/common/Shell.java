package com.bihe0832.common;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class Shell {

	public static void execShell(String cmd) {
		try {
			// 权限设置
			Process p = Runtime.getRuntime().exec("su");

			// 获取输出流
			OutputStream outputStream = p.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(
					outputStream);
			
			// 将命令写入
			dataOutputStream.writeBytes(cmd);
			
			// 提交命令
			dataOutputStream.flush();
			
			// 关闭流操作
			dataOutputStream.close();
			
		} catch (Throwable t) {
			t.printStackTrace();
		} 
	}
}
