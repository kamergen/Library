package library.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.Book;
import library.fakeDb.FakeDatebase;

@Repository
public class BookDao {

	@Autowired
	private FakeDatebase datebase;

	public Boolean addBook(Book book) {
		return datebase.getBookRepository().addBook(book);
	}

	public Boolean updateBook(Integer idBook, Book book) {
		return datebase.getBookRepository().updateBook(idBook,book);
	}

	public Boolean deleteBook(Integer idBook) {
		return datebase.getBookRepository().deleteBook(idBook);
	}

	public List<Book> getAllBook() {
		return datebase.getBookRepository().getAllBook();
	}
	
}
