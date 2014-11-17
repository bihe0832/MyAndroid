MyDemo
======


####URL编码中的空格：[http://bihe0832.sinaapp.com/200.html](http://bihe0832.sinaapp.com/200.html)
    - package： com.bihe0832.mydemo.UrlEncode
    - desc：分析空格在URL encode以后的情况
    - Summary：在HTML4.0.1中，基于RFC-1738标准，‘ ’在URL编码以后为 ‘+’，只有JS中由于基于RFC-2396标准，‘ ’在URL编码以后为‘%20’
    

======

####Android MD5后 bye数组转化为Hex字符串的坑：[http://bihe0832.sinaapp.com/172.html](http://bihe0832.sinaapp.com/172.html)

    - package： com.bihe0832.mydemo.IntToHexStr
    - desc：定位Java将bye转化为Hex str的一个偶先bug
    - Summary：一个byte是8位，而16进制是4位，所以要把一个bye转化为hex的时候，其高四位和低四位分别转化为为2个16进制字符。当高四位为0时，转化完要用‘0’补齐
