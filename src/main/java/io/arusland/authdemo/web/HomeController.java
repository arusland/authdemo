package io.arusland.authdemo.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.arusland.authdemo.AppProperties;
import io.arusland.authdemo.auth.AuthUtil;

@Controller
public class HomeController {
	@Autowired
	private AppProperties properties;

	@ResponseBody
	@RequestMapping("/")
	public String hello() {
		return "Hello from Spring Boot: enableApp=" + properties.isEnableApp();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/message/{message}")
	public String welcome(@PathVariable("message") String message, Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", message);
		model.put("user", AuthUtil.getUsername());

		return "welcome";
	}

	@RequestMapping("/exp")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@RequestMapping("/public")
	//@PreAuthorize("isAnonymous() or hasRole('ROLE_ADMIN')")
	public ModelAndView publicPart() {
		return new ModelAndView("info").addObject("user", AuthUtil.getUsername()).addObject("role",
				AuthUtil.getRoles().stream().findFirst().get());
	}
}
