package library.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/users/user/{id}/", method = RequestMethod.GET)
	public @ResponseBody User getUsers(@PathVariable int id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/users/user/search", method = RequestMethod.POST)
	public @ResponseBody List<User> getUsersSearch(@RequestBody User user) {

		return search.usersSearch(user);
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody User user){
		
		return regestrarion.addUser(user);
	}

	@RequestMapping(value = "/user/passBook", method = RequestMethod.DELETE)
	public @ResponseBody String passBook(@RequestBody BookInUse bookInUse) {
		return userService.passBook(bookInUse);
	}

	@RequestMapping(value = "/user/takeBook", method = RequestMethod.POST)
	public @ResponseBody String takeBook(@RequestBody BookInUse book) {
		return userService.takeBook(book);
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@RequestParam(required = true) int id) {
		return userService.deleteUser(id);
	}

}
