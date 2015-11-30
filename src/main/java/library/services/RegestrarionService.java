package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.UserDao;
import library.entities.User;

@Service
public class RegestrarionService {

	@Autowired
	private UserDao userDao;
	
	public Boolean addUser(User user) {
		return userDao.addUser(user);
	}
}
