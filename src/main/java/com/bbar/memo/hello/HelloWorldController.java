package com.bbar.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello world!!";
	}

}
