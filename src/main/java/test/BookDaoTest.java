package test;


import library.daos.BookDao;
import library.entities.Book;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDaoTest {

	private static String TITLE = "My First";
	private static String AUTHOR = "Hitler";
	private static String PUBLISHING_HOUSE = "HOUSE M.D.";

	// TODO remove
	private static int ID = 0;
	private static int YEAR = 2000;
	private static int PAGE_NUMBER = 1;

	@Autowired
	private BookDao bookDao;

	@Test
	public void test() {
		
	//	Book newBook = new Book(ID, TITLE, AUTHOR, PUBLISHING_HOUSE, YEAR, PAGE_NUMBER);
		//Assert.assertNotNull(newBook);
		//String message = bookDao.addBook(newBook);
//		//TODO do it in const
		//Assert.assertEquals(message, "success: book added");

	}
}

