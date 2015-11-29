package library.fakeDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FakeDatebase {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	public BookRepository getBookRepository() {
		return bookRepository;
	}
	public UsersRepository getUsersRepository() {
		return usersRepository;
	}
	
	

}
