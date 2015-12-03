package library.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.User;
import library.services.AuthenticationService;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService;
	
	
	@RequestMapping(value = "/user/login/", method = RequestMethod.POST)
	public @ResponseBody User login(HttpServletRequest request) {		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		return authService.login(email, password);
	}

}
