package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.BookDao;
import library.daos.UserDao;
import library.entities.Book;
import library.entities.User;

@Service
public class SearchService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;

	public List<User> usersSearch(User user) {
		return userDao.usersSearch(user);
	}

	public List<Book> bookSearch(Book book) {
		return bookDao.bookSearch(book);
	}
	
	
	
}
