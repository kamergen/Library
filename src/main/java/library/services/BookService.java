package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.entities.Book;
import library.entities.BookInUse;

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

	public String deleteBook(int id) {

		return bookDao.deleteBook(id);
	}

	public List<Book> getAllBook() {
		return bookDao.getAllBook();
	}

	public Book getBook(int id) {

		return bookDao.getBook(id);
	}

	public List<Book> getBooksUser(int id) {
		return bookDao.getBooksUser(id);
	}

	public BookInUse getBookStatus(int id) {
		return bookDao.getBookStatus(id);
	}

}
