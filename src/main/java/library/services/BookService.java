package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public String addBook(Book book) {

		return bookDao.addBook(book);
	}

	public String updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	public String deleteBook(Integer id) {

		return bookDao.deleteBook(id);
	}

	public List<Book> getAllBook() {
		return bookDao.getAllBook();
	}

	public Book getBook(Integer id) {

		return bookDao.getBook(id);
	}

	public List<Book> getBooksUser(Integer id) {
		return bookDao.getBooksUser(id);
	}

}
