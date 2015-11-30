package library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.Book;
import library.entities.User;
import library.services.FindService;


@Controller
public class FindController {

	@Autowired
	private FindService findService;
	
	@RequestMapping(path = "user/get", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam(required = true) String email) {
		return findService.getUser(email);
	}
	
	@RequestMapping(path = "book/get", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@RequestParam(required = true) Integer idBook) {		
		return findService.getBook(idBook);
	}
	
}
