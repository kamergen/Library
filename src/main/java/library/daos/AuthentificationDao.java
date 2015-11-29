package library.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.User;
import library.fakeDb.FakeDatebase;

@Repository
public class AuthentificationDao {

	@Autowired
	private FakeDatebase datebase;

	public User login(String email, String password) {
		return datebase.getUsersRepository().findOne(email, password);
	}

}
