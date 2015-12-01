package library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.daos.AuthentificationDao;
import library.entities.User;

@Service
public class AuthenticationService {

	@Autowired
	private AuthentificationDao authentificationDao;
	
/*	public User login(String email, String password) {				
		return authentificationDao.login(email,password);
	}*/	

}
