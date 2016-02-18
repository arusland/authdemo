package io.arusland.authdemo.web;


import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.arusland.authdemo.AppProperties;


@Controller
public class HomeController {
	@Autowired
	private AppProperties properties;
	
	
	@ResponseBody
	@RequestMapping("/")
	public String hello() {		
		return "Hello from Spring Boot: " + properties;
	}
	
	@RequestMapping("/message/{message}")
	public String welcome(@PathVariable("message") String message, Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", message);
		
		return "welcome";
	}
	
	@RequestMapping("/exp")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}
}
