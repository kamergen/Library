package library;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

import library.entities.User;
import library.fakeDb.UsersRepository;

@SpringBootApplication
public class Application {
	

	@Autowired 
	private UsersRepository usersRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	@PostConstruct
	public void init() {

		usersRepository.save(new User("Bilbo", "Baggins", "pas1","","q@.com"));
		usersRepository.save(new User("1Bilbo", "1Baggins", "pas1","","1q@.com"));
		usersRepository.save(new User("2Bilbo", "2Baggins", "pas1","","2q@.com"));
		SecurityUtils.runAs("system", "system", "ROLE_ADMIN");
		SecurityContextHolder.clearContext();
	}

}
