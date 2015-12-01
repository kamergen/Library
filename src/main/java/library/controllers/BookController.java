package library.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import library.entities.NewBook;
import library.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	private NewBook book;

	@RequestMapping(path = "book/get", method = RequestMethod.GET)
	public @ResponseBody NewBook getBook(@RequestParam(required = true) String id) {
		return bookService.getBook(Integer.valueOf(id));
	}

	@RequestMapping(path = "book/getall", method = RequestMethod.GET)
	public @ResponseBody List<NewBook> getAllBook() {
		return bookService.getAllBook();
	}

	@RequestMapping(path = "book/add", method = RequestMethod.POST)
	public @ResponseBody Boolean addBook(HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title").toString();
		String publishingHouse = request.getParameter("publishingHouse").toString();
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));

		book = new NewBook(id, title, publishingHouse, years, pageNumber);

		return bookService.addBook(book);
	}

	@RequestMapping(path = "book/update", method = RequestMethod.POST)
	public @ResponseBody Boolean updateBook(HttpServletRequest request) {

		int id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String publishingHouse = request.getParameter("publishingHouse");
		int years = Integer.valueOf(request.getParameter("years"));
		int pageNumber = Integer.valueOf(request.getParameter("pageNumber"));

		book = new NewBook(id, title, publishingHouse, years, pageNumber);

		return bookService.updateBook(book);
	}

	@RequestMapping(path = "book/delete", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteBook(@RequestParam(required = true) Integer id) {
		return bookService.deleteBook(id);
	}
}
