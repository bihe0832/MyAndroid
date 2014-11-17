package com.bihe0832.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.json.JSONObject;

import android.graphics.Bitmap;


/**
 * 常用工具�?
 * 
 */
public class T {

   /**
	 * 判断字符串是否为�?
	 * 
	 * @param s			�?要判断的字符�?
	 * @return boolean	为空返回true
	 */
	public static boolean ckIsEmpty(String s) {
		if (s == null || s.trim().equals("") || s.trim().equals("null")) {
			return true;
		}
		return false;
	}
	
    public static boolean ckNonEmpty(String... argvs) {
        for (String arg : argvs) {
            if (ckIsEmpty(arg)) {
                return true;
            }
        }
        return false;
    }
	/**
	 * 将bytes字节数据转换为string
	 * 
	 * @param bytes
	 * @return String
	 */
	public static final String arrayToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			buff.append(bytes[i] + " ");
		}
		return buff.toString();
	}

	/**
	 * 将字节数组转换为16进制字符�?
	 * 
	 * @param _bytes
	 * @return
	 */
	public static String bytes2HexString(byte[] _bytes) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (_bytes == null || _bytes.length <= 0) {
		    Logger.d("on CommonUtil.bytes2HexString _bytes is null !");
			return null;
		}
		for (int i = 0; i < _bytes.length; i++) {
			int v = _bytes[i] & 0xFF;
			String hv = Integer.toHexString(v);
			hv = hv.toUpperCase();
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**	将char转换为byte
	 *  
	 *  @param char
	 *  @return byte
	 * */
	public static byte char2Byte(char ch) {
		if (ch >= '0' && ch <= '9') {
			return (byte) (ch - '0');
		} else if (ch >= 'a' && ch <= 'f') {
			return (byte) (ch - 'a' + 10);
		} else if (ch >= 'A' && ch <= 'F') {
			return (byte) (ch - 'A' + 10);
		} else {
			return 0;
		}
	}

	/**
	 * 十六进制str转换为bytes
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hexStr2Bytes(String str) {
		if (str == null || str.equals("")) {
			return null;
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			char high = str.charAt(i * 2);
			char low = str.charAt(i * 2 + 1);
			bytes[i] = (byte) (char2Byte(high) * 16 + char2Byte(low));
		}
		return bytes;
	}

	/**
	 * 将bytes数组转换为二进制字符�?
	 * 
	 * @param _bytes
	 * @return
	 */
	public static String bytes2BinString(byte[] _bytes) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (_bytes == null || _bytes.length <= 0) {
		    Logger.d("on CommonUtil.bytes2BinString _bytes is null !");
			return null;
		}
		for (int i = 0; i < _bytes.length; i++) {
			int v = _bytes[i] & 0xFF;
			String hv = Integer.toBinaryString(v);
			for (int j = 8; j > hv.length(); j--) {
				stringBuilder.append("0");
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}


	/** 将Map中的数据转换为URL中GET方法的字符串
	 * 
	 * @param	map
	 * @return	String
	 * 
	 */
	public static String generateQueryString(Map<String,String> params) {
		if (params == null)
			return "";
		String aQueryParam = "";
		if (params.size() > 0) {
			Set<String> aKeySet = params.keySet();
			Iterator<String> aKeyIterator = aKeySet.iterator();
			while (aKeyIterator.hasNext()) {
				String aParamName = aKeyIterator.next();
				String aParamValue = encode(params.get(aParamName));
				aQueryParam += aParamName + "=" + aParamValue + "&";
			}
			aQueryParam = aQueryParam.substring(0, aQueryParam.length() - 1);
		}
		return aQueryParam;
	}

	/** 将Map转换为Json格式的字符串
	 * 
	 * @param	map
	 * @return	String
	 */
	public static String generateQueryJson(Map<String,String> params) {
	
		if(params == null || params.isEmpty())
			return "";
		
		JSONObject aJsonObject = new JSONObject(params);
		return aJsonObject.toString();
	}

	/**
	 * 统一为标准的编码，主要解决几个特殊字�?
	 * @param value
	 * @return
	 */
	public static String encode(String value) {
		String encoded = "";
		try {
			encoded = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
		}
		StringBuffer buf = new StringBuffer(encoded.length());
		char focus;
		for (int i = 0; i < encoded.length(); i++) {
			focus = encoded.charAt(i);
			if (focus == '*') {
				buf.append("%2A");
			} else if (focus == '+') {
				buf.append("%20");
			} else if (focus == '%' && (i + 1) < encoded.length()
					&& encoded.charAt(i + 1) == '7'
					&& encoded.charAt(i + 2) == 'E') {
				buf.append('~');
				i += 2;
			} else {
				buf.append(focus);
			}
		}
		return buf.toString();
		
	}
	
	/**
	 * 判断某个队列中是否有该字符串
	 * 
	 * @param srcStr
	 * @param orgList
	 * */
	public static boolean strIsInList(String srcStr, List<String> orgList)
	{
		if(orgList == null)
			return true;
		for(String strList:orgList)
			if(strList.equals(srcStr))
				return false;
		
		return true;
		
	}
	
	private static final char[] digits = new char[]{'0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * 上报用户数据使用 是小写的字符
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytes2HexStr(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		char[] buf = new char[2 * bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			buf[2 * i + 1] = digits[b & 0xF];
			b = (byte) (b >>> 4);
			buf[2 * i + 0] = digits[b & 0xF];
		}
		return new String(buf);
	}

	/**
	 * 返回bitmap的数组大�?
	 * 
	 * @param bm
	 * @return
	 */
	public static byte[] bitmap2Bytes(Bitmap bm) {
	    if(bm == null) {
	        return null;
	    }
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();
	}
	
	
	 /**
     * @param source 传入带参数的url,�?:http://www.qq.com/ui/oa/test.html?name=hao&id=123
     * @return 去掉参数的url,�?:http://www.qq.com/ui/oa/test.html
     */
    public static String getNoQueryUrl(String source) {
        String dest = null;
        try {
            URL sUrl = new URL(source);
            URL dUrl = new URL(sUrl.getProtocol(), sUrl.getHost(), sUrl.getPort(), sUrl.getPath());
            dest = dUrl.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return dest;
    }
    
	/**
	 * 指定长度的随机字符串
	 * @param len	随机字符串长�?
	 * @return 获取到的随机字符�?
	 */
	public static String getRandomString(int len) {
		String returnStr = "";
		char[] ch = new char[len];
		Random rd = new Random();
		for (int i = 0; i < len; i++) {
			ch[i] = (char) (rd.nextInt(9) + 97);
		}
		returnStr = new String(ch);
		return returnStr;
	}
}
