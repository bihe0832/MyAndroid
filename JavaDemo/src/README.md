### IntToHexStr：
#### 博文地址：[Android MD5后 bye数组转化为Hex字符串的坑](http://blog.bihe0832.com/AndroidMD5%E5%90%8Ebye%E6%95%B0%E7%BB%84%E8%BD%AC%E5%8C%96%E4%B8%BAHex%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E5%9D%91.html)
#### 概述：一个byte是8位，而16进制是4位，所以要把一个bye转化为hex的时候，其高四位和低四位分别转化为为2个16进制字符。当高四位为0时，转化完要用‘0’补齐
