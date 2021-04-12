package com.rrobi.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String HelloWorld() {
		
		return "Hello World!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean Hello() {
		
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping(path = "/good-morning-i18n")
	public String GoodMorningInternationalized() {
		
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
