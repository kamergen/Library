package library.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	/*@RequestMapping(path = "book/getall", method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBook() {		
		return bookService.getAllBook();
	}*/
	
/*	@RequestMapping(path = "book/add", method = RequestMethod.POST)
	public @ResponseBody Boolean addBook(HttpServletRequest request) {
		
		int idBook = Integer.valueOf(request.getParameter("idBook"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		
		book = new Book(idBook, title, publishingHouse, years, pageNumber);
		
		return bookService.addBook(book);
	}
	
	@RequestMapping(path = "book/update", method = RequestMethod.POST)
	public @ResponseBody Boolean updateBook(@RequestParam(required = true) String idBook, HttpServletRequest request) {
		
		int id = Integer.valueOf(idBook);
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));
		
		book = new Book(id, title, publishingHouse, years, pageNumber);
		
		return bookService.updateBook(id,book);
	}
	
	@RequestMapping(path = "book/delete", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteBook(@RequestParam(required = true) Integer idBook) {		
		return bookService.deleteBook(idBook);
	}*/
}
