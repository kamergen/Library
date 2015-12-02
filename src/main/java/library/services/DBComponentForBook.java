package library.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import library.DataConfig;
import library.mapper.BookMapper;

@Service
public class DBComponentForBook {

	public BookMapper dbComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		BookMapper mapper = ctx.getBean(BookMapper.class);
		return mapper;
	}
}
