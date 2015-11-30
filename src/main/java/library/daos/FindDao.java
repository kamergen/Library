package library.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.Book;
import library.entities.User;
import library.fakeDb.FakeDatebase;

@Repository
public class FindDao {

	@Autowired
	private FakeDatebase datebase;
	
	public User getUser(String email) {
		return datebase.getUsersRepository().findOne(email);
	}
	
	public Book getBook(Integer idBook) {
		return datebase.getBookRepository().findOne(idBook);
	}
	
}
