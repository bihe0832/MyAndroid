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
 * 常用工具类
 * 
 * @author hardyshi
 * * 
 */
public class CommonUtil {

    public static String generateHttpBaseQueryString(String url, String action, String lowerCase,
            HashMap<String, String> params) {
        return null;
    }
   /**
	 * 判断字符串是否为空
	 * 
	 * @param s			需要判断的字符串
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
	 * URL encode推荐方法
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
	
	/**
	 * 返回bitmap的数组大小
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
     * @param source 传入带参数的url,如:http://www.qq.com/ui/oa/test.html?name=hao&id=123
     * @return 去掉参数的url,如:http://www.qq.com/ui/oa/test.html
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
	 * @param len	随机字符串长度
	 * @return 获取到的随机字符串
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
