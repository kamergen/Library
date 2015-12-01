package library.daos;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import library.DataConfig;
import library.entities.BookInUse;
import library.entities.User;
import library.mapper.UserMapper;

@Repository
public class UserDao {

	public List<User> getAllUsers() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);

		List<User> users = mapper.getAllUser();
		ctx.close();

		return users;
	}

	public Boolean deleteUser(int id) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);
		try {
			mapper.deleteUser(id);
			ctx.close();
			return true;

		} catch (Exception e) {
			ctx.close();
			return false;
		}
	}

	public Boolean addUser(User user) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);

		mapper.addUser(user);
		ctx.close();
		return true;
	}

	public Boolean takeBook(BookInUse bookInUse) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);

		mapper.takeBook(bookInUse);
		ctx.close();
		return true;
	}
	
	public User getUser(Integer id) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);
		
		User user = mapper.getUser(id);
		ctx.close();
		
		return user;
	}

	public Boolean passBook(Integer id) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);
		
		mapper.passBook(id);		
		return true;
	}
}
