package com.bihe0832.mydemo.IntToHexStr;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.util.Log;

import com.bihe0832.mydemo.MainActivity;

public class IntToHexStr  {

	public static String goddessMD5(String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i=0; i<messageDigest.length; i++){
	        	hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	        	Log.i(MainActivity.TAG,Integer.toHexString(0xFF & messageDigest[i]));
	        }
	        return hexString.toString();

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	

	public static String myMD5(String s) {
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        String tempStr = "";
	        for (int i=0; i<messageDigest.length; i++){
	        	if(Integer.toHexString(0xFF & messageDigest[i]).length() < 2){
	        		tempStr = "0"+Integer.toHexString(0xFF & messageDigest[i]);
	        	}else{
	        		tempStr = Integer.toHexString(0xFF & messageDigest[i]);
	        	}
	        	hexString.append(tempStr);
	        }
	        return hexString.toString();

	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	public static void main(String[] args) {
		String originalSig = "4578e54fb3a1bd18e0681bc1c734514e";
		System.out.println("originalSig:"+originalSig); 
		System.out.println("my      md5 :"+com.bihe0832.mydemo.IntToHexStr.IntToHexStr.myMD5(originalSig)); 
		System.out.println("goddess md5 :"+com.bihe0832.mydemo.IntToHexStr.IntToHexStr.goddessMD5(originalSig)); 
    }
}
