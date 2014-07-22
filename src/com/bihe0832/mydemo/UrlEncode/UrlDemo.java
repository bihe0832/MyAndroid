package com.bihe0832.mydemo.UrlEncode;

import android.util.Log;

public class UrlDemo {

	public static void test() {  
		String tempString = "Hello, World!";
		String temStringAfterEncode = "";
		try {
			temStringAfterEncode = java.net.URLEncoder.encode(tempString,"UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			Log.i("UrlDemo", "bad encoding type"); 
		}
		Log.i("UrlDemo", tempString); 
		Log.i("UrlDemo", temStringAfterEncode); 
		
		android.net.Uri.encode(tempString);
		Log.i("UrlDemo", tempString); 
		Log.i("UrlDemo", temStringAfterEncode); 
	}
	
}
