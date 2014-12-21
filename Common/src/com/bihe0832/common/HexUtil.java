package com.bihe0832.common;



public class HexUtil
{
    private static final char[] digits = new char[] { '0', '1', '2', '3', '4',//
            '5', '6', '7', '8', '9',//
            'A', 'B', 'C', 'D', 'E',//
            'F' };

    public static final byte[] emptybytes = new byte[0];

    /**
     * 将单个字节转成Hex String
     * @param b   字节
     * @return String Hex String
     */
    public static String byte2HexStr(byte b)
    {
        char[] buf = new char[2];
        buf[1] = digits[b & 0xF];
        b = (byte) (b >>> 4);
        buf[0] = digits[b & 0xF];
        return new String(buf);
    }

    /**
     * 将字节数组转成Hex String
     * @param b
     * @return String
     */
    public static String bytes2HexStr(byte[] bytes)
    {
        if (bytes == null || bytes.length == 0)
        {
            return null;
        }

        char[] buf = new char[2 * bytes.length];
        for (int i = 0; i < bytes.length; i++)
        {
            byte b = bytes[i];
            buf[2 * i + 1] = digits[b & 0xF];
            b = (byte) (b >>> 4);
            buf[2 * i + 0] = digits[b & 0xF];
        }
        return new String(buf);
    }

    /**
     * 将单个hex Str转换成字节
     * @param str
     * @return byte
     */
    public static byte hexStr2Byte(String str)
    {
        if (str != null && str.length() == 1)
        {
            return char2Byte(str.charAt(0));
        }
        else
        {
            return 0;
        }
    }

    /**
     * 字符到字节
     * @param ch
     * @return byte
     */
    public static byte char2Byte(char ch)
    {
        if (ch >= '0' && ch <= '9')
        {
            return (byte) (ch - '0');
        }
        else if (ch >= 'a' && ch <= 'f')
        {
            return (byte) (ch - 'a' + 10);
        }
        else if (ch >= 'A' && ch <= 'F')
        {
            return (byte) (ch - 'A' + 10);
        }
        else
        {
            return 0;
        }
    }

    public static byte[] hexStr2Bytes(String str)
    {
        if (str == null || str.equals(""))
        {
            return emptybytes;
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++)
        {
            char high = str.charAt(i * 2);
            char low = str.charAt(i * 2 + 1);
            bytes[i] = (byte) (char2Byte(high) * 16 + char2Byte(low));
        }
        return bytes;
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
	 * 将字节数组转换为16进制字符串
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

	/**
	 * 将bytes数组转换为二进制字符串
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
}
