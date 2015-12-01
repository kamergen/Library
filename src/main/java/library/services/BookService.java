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
	
	public Boolean updateBook(NewBook book) {
		return bookDao.updateBook(book);
	}

	public Boolean deleteBook(Integer id) {

		return bookDao.deleteBook(id);
	}
	public List<NewBook> getAllBook() {
		return bookDao.getAllBook();
	}

	public NewBook getBook(Integer id) {

		return bookDao.getBook(id);
	}

	
	
}
