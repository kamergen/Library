package test;


import library.Application;
import library.daos.BookDao;
import library.entities.Book;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDaoTest {

	private static String TITLE = "My First";
	private static String AUTHOR = "Savushkin S.D.";
	private static String PUBLISHING_HOUSE = "HOUSE M.D.";
	private static int YEAR = 2000;
	private static int PAGE_NUMBER = 1;

	static Logger log = Logger.getLogger(Application.class.getName());
	
	@Autowired
	private BookDao bookDao;

	@Test
	public void test() {
		
		log.debug("test was started");
		Book newBook = new Book(TITLE, AUTHOR, PUBLISHING_HOUSE, YEAR, PAGE_NUMBER);
		Assert.assertNotNull(newBook);
		String message = bookDao.addBook(newBook);
		
		//TODO do it in const
		Assert.assertEquals(message, "success: book added");

	}
}

