package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.UserDao;
import library.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Boolean updateUser(String email, User user) {
		return null;
	}

	public Boolean deleteBook(String email) {

		return userDao.deleteUser(email);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
