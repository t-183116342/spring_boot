package com.hqyj.shiro;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbShiroApplication.class, args);
		
		// close the banner
//		SpringApplication application = new SpringApplication(SbShiroApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.run(args);
	}

}
