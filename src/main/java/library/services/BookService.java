package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao; 
	
	public Book getBook(Integer idBook) {
		return bookDao.getBook(idBook);
	}

	public Book addBook(Book book) {

		return bookDao.addBook(book);
	}

	public Book updateBook(Integer id, Book book) {
		return bookDao.updateBook(id,book);
	}

	
	
}
