package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.entities.Book;
import library.entities.NewBook;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao; 
	
	public Boolean addBook(NewBook book) {

		return bookDao.addBook(book);
	}
/*
	public Boolean updateBook(Integer idBook, Book book) {
		return bookDao.updateBook(idBook,book);
	}

	public Boolean deleteBook(Integer idBook) {

		return bookDao.deleteBook(idBook);
	}
*/
	public List<NewBook> getAllBook() {
		return bookDao.getAllBook();
	}

	
	
}
