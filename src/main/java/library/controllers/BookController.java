package library.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	private Integer idBook;
	private Book book;
	
	
	@RequestMapping(path = "book/getBook", method = RequestMethod.GET)
	public @ResponseBody Book getBook(@RequestParam(required = true) Integer idBook) {		
		return bookService.getBook(idBook);
	}
	
	@RequestMapping(path = "book/addBook", method = RequestMethod.POST)
	public @ResponseBody Book addBook(HttpServletRequest request) {
		
		int idBook = Integer.valueOf(request.getParameter("idBook"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		
		book = new Book(idBook, title, publishingHouse, years, pageNumber);
		
		return bookService.addBook(book);
	}
	
	@RequestMapping(path = "book/addBook", method = RequestMethod.POST)
	public @ResponseBody Book updateBook(@RequestParam(required = true) String id, HttpServletRequest request) {
		
		int idBook = Integer.valueOf(request.getParameter("idBook"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		
		book = new Book(idBook, title, publishingHouse, years, pageNumber);
		
		return bookService.updateBook(Integer.valueOf(id),book);
	}
	
}
