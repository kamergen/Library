package library.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.User;
import library.fakeDb.FakeDatebase;

@Repository
public class UserDao {
	@Autowired
	FakeDatebase datebase;

	public List<User> getAllUsers() {
		return datebase.getUsersRepository().getAllUsers();
	}

	public Boolean deleteUser(String email) {
		return datebase.getUsersRepository().delete(email);
	}

	public Boolean addUser(User user) {
		return datebase.getUsersRepository().addUser(user);
	}

}
