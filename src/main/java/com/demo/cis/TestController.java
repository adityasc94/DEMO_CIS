package com.demo.cis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(value = "/test")
	public String testApi() {
		return "Hello";
	}
}
