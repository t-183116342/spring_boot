package com.hqyj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;;

@SpringBootApplication
public class SbDemoApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SbDemoApplication.class);
		// 关闭banner
//		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run();
	}

}
