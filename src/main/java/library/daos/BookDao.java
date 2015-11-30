package library.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import library.entities.Book;
import library.fakeDb.FakeDatebase;

@Repository
public class BookDao {

	@Autowired
	private FakeDatebase datebase;
	
	/*public Book addBook(String title, String publishingHouse, int years, int pageNumber){
		
	}*/

	public Book getBook(Integer idBook) {
		return datebase.getBookRepository().findOne(idBook);
	}

	public Book addBook(Book book) {
		return datebase.getBookRepository().save(book);
	}

	public Book updateBook(Integer id, Book book) {
		return datebase.getBookRepository().updateBook(id,book);
	}
	
}
