package library;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

import library.entities.Book;
import library.entities.User;
import library.fakeDb.BookRepository;
import library.fakeDb.UsersRepository;

@SpringBootApplication
public class Application {
	

	@Autowired 
	private UsersRepository usersRepository;
	@Autowired 
	private BookRepository bookRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	/**
	 * Pre-load the system with employees and items.
	 */
	@PostConstruct
	public void init() {

		usersRepository.save(new User("Bilbo", "Baggins", "pas1","","q@.com"));
		usersRepository.save(new User("1Bilbo", "1Baggins", "pas1","","1q@.com"));
		usersRepository.save(new User("2Bilbo", "2Baggins", "pas1","","2q@.com"));

		bookRepository.save(new Book("bucvar", "bucvarHouse", 102, 1022));
		bookRepository.save(new Book("bucvar2", "bucvarHouse2", 2015, 2541));
		
		
		
		/**
		 * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
		 * with an authentication token containing the necessary privileges.
		 */
		SecurityUtils.runAs("system", "system", "ROLE_ADMIN");

		

		SecurityContextHolder.clearContext();
	}

}
