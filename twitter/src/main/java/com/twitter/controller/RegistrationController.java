package com.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twitter.domain.User;
import com.twitter.service.UserService;

@Controller
//@RequestMapping("/register")
public class RegistrationController 
{
	private UserService userService;
	
	@Autowired
	public RegistrationController (final UserService userService)
	{
		this.userService= userService;
	}
	
	@GetMapping
	public String registerPage()
	{
		return "registration";
	}
	
	@PostMapping
	@RequestMapping("/register")
	public @ResponseBody String processRegistration(@RequestBody User user)
	{
		String answer;
		
		answer= userService.userRegistration(user);
		
		return answer;	
	}
	
	/*@PostMapping
	public ResponseEntity<String> processRegistration(HttpServletResponse response, @RequestBody User user) throws IOException
	{
		String answer;
		
		answer= userService.userRegistration(user);
		
		if(answer.equals("1"))
			response.sendRedirect("/login.html");
			//return "redirect:/login.html";
		
    	return ResponseEntity.ok(answer);
	}*/
}
