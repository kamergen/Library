package library.controllers;

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
import library.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	private Book book;
	
	@RequestMapping(value = "/books/user/{id}/", method = RequestMethod.POST)
	public @ResponseBody List<Book> getBooksUser(@PathVariable Integer id) {

		return bookService.getBooksUser(id);
	}

	@RequestMapping(value = "/books/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/books/book/all", method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public @ResponseBody String addBook(HttpServletRequest request) {

		int idBook = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		String author = request.getParameter("author");
		book = new Book(idBook, title, author, publishingHouse, years, pageNumber);
		
		return bookService.addBook(book);
	}

	@RequestMapping(value = "/book/update", method = RequestMethod.POST)
	public @ResponseBody String updateBook(HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		String author = request.getParameter("author").toString();
		
		book = new Book(id, title, author, publishingHouse, years, pageNumber);

		return bookService.updateBook(book);
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE)
	public @ResponseBody String deleteBook(@RequestParam(required = true) Integer id) {
		return bookService.deleteBook(id);
	}
}
