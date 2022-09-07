#### 博文地址：[URL编码中的空格(编码以后变为+)](https://blog.bihe0832.com/url_space.html)

#### 在HTML4.0.1中，基于RFC-1738标准，‘ ’在URL编码以后为 ‘+’，只有JS中由于基于RFC-2396标准，‘ ’在URL编码以后为‘%20’。

最后推荐一个MSDK开发使用的encode函数：

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

## 上述代码地址：<https://github.com/bihe0832/MyDemo/tree/master/Common>

