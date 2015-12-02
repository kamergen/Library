package library.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.Book;
import library.entities.BookInUse;
import library.entities.User;
import library.services.RegestrarionService;
import library.services.SearchService;
import library.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RegestrarionService regestrarion;
	@Autowired
	private SearchService search;
	private User user;

	@RequestMapping(value = "/users/user/{id}/", method = RequestMethod.GET)
	public @ResponseBody User getUsers(@PathVariable Integer id) {
		return userService.getUser(Integer.valueOf(id));
	}

	@RequestMapping(value = "/users/user/all", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/users/user/search", method = RequestMethod.POST)
	public @ResponseBody List<User> getUsersSearch(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");

		return search.usersSearch(firstName);
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public @ResponseBody String addUser(HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String avatar = request.getParameter("avatar");
		String email = request.getParameter("email");
		String role = request.getParameter("role");

		user = new User(id, firstName, lastName, password, avatar, email, role);

		return regestrarion.addUser(user);
	}

	@RequestMapping(value = "/user/passBook", method = RequestMethod.DELETE)
	public @ResponseBody String passBook(@RequestParam(required = true) Integer id) {
		return userService.passBook(id);
	}

	@RequestMapping(value = "/user/takeBook", method = RequestMethod.POST)
	public @ResponseBody String takeBook(HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		int id_user = Integer.valueOf(request.getParameter("id_user"));
		int id_book = Integer.valueOf(request.getParameter("id_book"));
		int bookStatus = Integer.valueOf(request.getParameter("bookStatus"));

		int yearsStart = Integer.valueOf(request.getParameter("yearsStart"));
		int monthStart = Integer.valueOf(request.getParameter("monthStart"));
		int dayStart = Integer.valueOf(request.getParameter("dayStart"));
		Date startDate = new Date(yearsStart, monthStart, dayStart);

		int yearsEnd = Integer.valueOf(request.getParameter("yearsEnd"));
		int monthEnd = Integer.valueOf(request.getParameter("monthEnd"));
		int dayEnd = Integer.valueOf(request.getParameter("dayEnd"));
		Date endDate = new Date(yearsEnd, monthEnd, dayEnd);

		BookInUse bookInUse = new BookInUse(id, id_user, id_book, bookStatus, startDate, endDate);

		return userService.takeBook(bookInUse);
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@RequestParam(required = true) String id) {
		return userService.deleteUser(Integer.valueOf(id));
	}

}
