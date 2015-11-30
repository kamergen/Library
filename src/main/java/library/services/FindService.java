package library.services;

import org.springframework.beans.factory.annotation.Autowired;

import library.daos.FindDao;
import library.entities.Book;
import library.entities.User;

public class FindService {

	@Autowired
	private FindDao findDao;
	
	public User getUser(String email) {
		return findDao.getUser(email);
	}
	
	public Book getBook(Integer idBook) {
		return findDao.getBook(idBook);
	}
}
