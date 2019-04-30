package com.oauth.init.endpoint;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/")
	public String startPage() {
		return "startPage";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
