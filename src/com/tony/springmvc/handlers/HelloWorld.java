package com.tony.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	/**
	 * 1. Use RequestMapping to map request URL
	 * 2. Return value will go to "view" by view parser:
	 * "prefix + resturnval + suffix": the file it will be forwarding to.
	 * 
	 * 
	 * @return
	 */
	
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("Hello World");
		return "success";
	}
	
}
