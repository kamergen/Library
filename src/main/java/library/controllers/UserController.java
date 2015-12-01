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
import library.services.RegestrarionService;
import library.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RegestrarionService regestrarion;

	private User user;

/*	@RequestMapping(path = "user/getall", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}*/

/*	@RequestMapping(path = "user/add", method = RequestMethod.POST)
	public @ResponseBody Boolean addUser(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String avatar = request.getParameter("avatar");
		String email = request.getParameter("email");

		user = new User(firstName, lastName, password, avatar, email);

		return regestrarion.addUser(user);
	}

	@RequestMapping(path = "user/delete", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteUser(@RequestParam(required = true) String email) {
		return userService.deleteBook(email);
	}*/

}
