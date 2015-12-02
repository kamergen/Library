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

	public String deleteUser(Integer id) {

		return userDao.deleteUser(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUser(Integer id) {
		return userDao.getUser(id);
	}
	
	public User login(String email, String password) {				
		return userDao.login(email,password);
	}
	
	public String takeBook(BookInUse bookInUse) {
		return userDao.takeBook(bookInUse);
	}

	public String passBook(Integer id) {
		return userDao.passBook(id);
	}

}
