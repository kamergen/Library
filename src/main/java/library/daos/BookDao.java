package library.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.Book;
import library.entities.BookInUse;
import library.services.DBComponentForBook;

@Repository
public class BookDao {
	
	@Autowired
	private DBComponentForBook component;

	public Book getBook(int id) {

		try {
			final Book book = component.dbComponent().getBook(id);
			component.dbComponent();
			return book;

		} catch (Exception e) {
			return null;
		}
	}

	public String addBook(Book book) {

		try {
			component.dbComponent().addBook(book);
			return "success: book added";

		} catch (Exception e) {

			return "error: the book is not added";
		}
	}

	public String updateBook(Book book) {

		try {
			component.dbComponent().updateBook(book);
			return "success: book changed";

		} catch (Exception e) {
			return "error: the book is not changed";
		}
	}

	public String deleteBook(int id) {

		try {
			component.dbComponent().deleteBook(id);
			return "success: dook deleted";
		} catch (Exception e) {
			return "error: the book is not deleted";
		}
	}

	public List<Book> getAllBook() {
		try {

			List<Book> books = component.dbComponent().getAllBook();
			return books;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Book> getBooksUser(int id) {
		try {
			return component.dbComponent().getBooksUser(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Book> bookSearch(Book book) {
			try {
				return component.dbComponent().bookSearch(book);
			} catch (Exception e) {
			}
			return null;
	}

	public BookInUse getBookStatus(int id) {
		try {
			return component.dbComponent().getBookStatus(id);
		} catch (Exception e) {
		}
		return null;
	}
}
