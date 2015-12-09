package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.UserDao;
import library.entities.User;

@Service
public class AuthenticationService {

	@Autowired
	private UserDao userDao;
	
	public User login(User user) {				
		return userDao.login(user);
	}

}
