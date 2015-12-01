package library.daos;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import library.DataConfig;
import library.entities.NewBook;
import library.mapper.BookMapper;

@Repository
public class BookDao {

	public NewBook getBook(Integer id) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		NewBook book = mapper.getBook(id);
		ctx.close();
		return book;
	}

	public Boolean addBook(NewBook book) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		try {
			ctx.close();
			mapper.addBook(book);

			return true;

		} catch (Exception e) {
			ctx.close();
			return false;
		}
	}

	public Boolean updateBook(NewBook book) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		try {
			ctx.close();
			mapper.updateBook(book);
			return true;

		} catch (Exception e) {
			ctx.close();
			return false;
		}
	}

	public Boolean deleteBook(Integer id) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		try {
			ctx.close();
			mapper.deleteBook(id);

			return true;

		} catch (Exception e) {
			ctx.close();
			return false;
		}
	}

	public List<NewBook> getAllBook() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);

		List<NewBook> books = mapper.getAllBook();
		ctx.close();
		return books;
	}

}
