package library.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.BookInUse;
import library.entities.User;
import library.services.DBComponentForUser;

@Repository
public class UserDao {

	@Autowired
	private DBComponentForUser component;

	public List<User> getAllUsers() {

		try {
			List<User> users = component.dbComponent().getAllUser();
			return users;
		} catch (Exception e) {
			return null;
		}
	}

	public String deleteUser(int id) {

		try {
			component.dbComponent().deleteUser(id);
			return "success: user deleted";

		} catch (Exception e) {
			return "error: the user is not deleted";
		}
	}

	public String addUser(User user) {
		try {
			component.dbComponent().addUser(user);
			return "success: user added";
		} catch (Exception e) {
			return "error: the user is not added";
		}
	}

	public String takeBook(BookInUse bookInUse) {

		try {
			component.dbComponent().takeBook(bookInUse);
			return "success: book taken";
		} catch (Exception e) {
			return "error: the book is not taken";
		}
	}

	public User getUser(Integer id) {
		try {
			User user = component.dbComponent().getUser(id);
			return user;
		} catch (Exception e) {
			return null;
		}

	}

	public String passBook(Integer id) {
		try {
			component.dbComponent().passBook(id);
			return "success: book passed";
		} catch (Exception e) {
			return "error: the book not passed";
		}

	}

	public List<User> usersSearch(String firstName) {

		try {
			return component.dbComponent().usersSearch(firstName);
		} catch (Exception e) {
		}
		return null;
	}

	public User login(User user) {
			return component.dbComponent().login(user);
	}
}
