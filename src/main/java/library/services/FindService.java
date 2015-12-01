package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.FindDao;
import library.entities.Book;
import library.entities.User;

@Service
public class FindService {

	@Autowired
	private FindDao findDao;
	
	/*public User getUser(String email) {
		return findDao.getUser(email);
	}*/
	
	public Book getBook(Integer id) {
		return findDao.getBook(id);
	}
}
