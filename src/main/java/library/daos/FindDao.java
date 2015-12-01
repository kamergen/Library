package library.daos;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import library.DataConfig;
import library.entities.Book;
import library.mapper.BookMapper;

@Repository
public class FindDao {


	/*public User getUser(String email) {
		return datebase.getUsersRepository().findOne(email);
	}*/

	public Book getBook(Integer id) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		Book book = mapper.getBook(id); 
		
		return book;
	}

}
