package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.entities.Book;
import library.entities.NewBook;

@Service
public class FindService {

	@Autowired
	private BookDao bookDao;
	
	/*public User getUser(String email) {
		return findDao.getUser(email);
	}*/
	
	public NewBook getBook(Integer id) {
		return bookDao.getBook(id);
	}
}
