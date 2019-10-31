package com.hqyj.erp.util;

import org.springframework.util.DigestUtils;

/**
 * MD5 Util
 * @author: HymanHu
 * @date: 2019年10月29日
 */
public class MD5Util {
	private static final String SALT = "&%5123***&&%%$$#@";
	
	public static String getMD5(String str) {
		String base = str + "/" + SALT;
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
}
