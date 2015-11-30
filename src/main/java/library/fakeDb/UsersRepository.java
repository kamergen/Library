package library.fakeDb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Repository;

import library.entities.User;

@Repository
public class UsersRepository implements CrudRepository<User, Integer> {

	private ArrayList<User> users = new ArrayList<>();

	@Override
	public <S extends User> S save(S user) {
		users.add(user);
		return user;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public User findOne(Integer id) {
		return users.get(id);
	}

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return users.size();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public User findOne(String email, String password) throws AuthenticationException {
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(password)) {
					return user;
				}
			}
		}
		return null;

	}

	public User findOne(String email) {
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
	}

	public List<User> getAllUsers() {
		return users;
	}

	public Boolean delete(String email) {
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				users.remove(user);
				return true;
			}
		}
		return false;
	}

	public Boolean addUser(User user) {
		try {
			users.add(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
