package library.fakeDb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.Book;

@Repository
public class FakeDatebase {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	ArrayList<Book> books = new ArrayList<>();
	
	public BookRepository getBookRepository() {
		return bookRepository;
	}
	public UsersRepository getUsersRepository() {
		return usersRepository;
	}

}
