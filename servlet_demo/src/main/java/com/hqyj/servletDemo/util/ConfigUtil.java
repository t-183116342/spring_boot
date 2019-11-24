package com.hqyj.servletDemo.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 配置工具类
 * @author: HymanHu
 * @date: 2019年11月23日
 */
public class ConfigUtil {

	public static Properties properties = new Properties();
	
	/**
	 * 先将配置文件读取到properties文件中
	 */
	static {
		InputStream is = null;
		try {
			is = ConfigUtil.class.getClassLoader().getResourceAsStream("jdbc-parms.properties");
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigUtil.properties.getProperty("jdbc.url", ""));
	}
}
