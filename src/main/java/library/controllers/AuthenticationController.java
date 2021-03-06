package library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.User;
import library.services.AuthenticationService;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;

	@RequestMapping(value = "/user/login/", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody User user) {
		
		return authService.login(user);
	}
}
