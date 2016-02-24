package library.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import library.DataConfig;
import library.mapper.UserMapper;

@Service
public class DBComponentForUser {

	public UserMapper dbComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(DataConfig.class);
		ctx.refresh();
		UserMapper mapper = ctx.getBean(UserMapper.class);
		ctx.close();
		return mapper;
	}
}
