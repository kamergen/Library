package library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.Book;
import library.entities.BookInUse;
import library.entities.User;
import library.services.BookService;
import library.services.SearchService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private SearchService search;

	@RequestMapping(value = "/books/user/{id}/", method = RequestMethod.POST)
	public @ResponseBody List<Book> getBooksUser(@PathVariable Integer id) {
		return bookService.getBooksUser(id);
	}

	@RequestMapping(value = "/books/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(value = "/book/status/{id}", method = RequestMethod.GET)
	public @ResponseBody BookInUse getBookStatus(@PathVariable Integer id) {
		return bookService.getBookStatus(id);
	}

	@RequestMapping(value = "/books/all", method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	@RequestMapping(value = "/books/book/search", method = RequestMethod.POST)
	public @ResponseBody List<Book> getBooksSearch(@RequestBody Book book) {

		return search.bookSearch(book);
	}
	
	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public @ResponseBody String addBooks(@RequestBody Book book) {

		return bookService.addBook(book);
	}

	@RequestMapping(value = "/books/update", method = RequestMethod.POST)
	public @ResponseBody String updateBook(@RequestBody Book book) {

		return bookService.updateBook(book);
	}

	@RequestMapping(value = "/books/delete", method = RequestMethod.DELETE)
	public @ResponseBody String deleteBook(@RequestParam(required = true) Integer id) {
		return bookService.deleteBook(id);
	}
}
