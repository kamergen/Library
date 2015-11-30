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
	
	public Boolean addBook(Book book) {

		return bookDao.addBook(book);
	}

	public Boolean updateBook(Integer idBook, Book book) {
		return bookDao.updateBook(idBook,book);
	}

	public Boolean deleteBook(Integer idBook) {

		return bookDao.deleteBook(idBook);
	}

	public List<Book> getAllBook() {
		return bookDao.getAllBook();
	}

	
	
}
