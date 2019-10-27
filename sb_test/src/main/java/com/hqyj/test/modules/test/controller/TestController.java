package com.hqyj.test.modules.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test/info")
	public String testString() {
		return "This is a test app.";
	}
}
