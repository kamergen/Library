package library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.UserDao;
import library.entities.User;

@Service
public class SearchService {

	@Autowired
	private UserDao userDao;

	public List<User> usersSearch(String firstName) {

		return userDao.usersSearch(firstName);
	}
	
	
	
}
