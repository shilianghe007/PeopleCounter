package com.whu.programmer.util;
/*
 * 
 * string类的共用操作方法
 */
public class StringUtil {
public static boolean isEmpty(String str) {
	if(str==null||"".equals(str))return true;
	return false;
}
}
