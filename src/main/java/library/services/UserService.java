package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.UserDao;
import library.entities.BookInUse;
import library.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public String deleteUser(int id) {

		return userDao.deleteUser(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUser(int id) {
		return userDao.getUser(id);
	}

	
	public String takeBook(BookInUse bookInUse) {
		return userDao.takeBook(bookInUse);
	}

	public String passBook(BookInUse bookInUse) {
		return userDao.passBook(bookInUse);
	}

}
