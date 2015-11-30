package library.fakeDb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import library.entities.Book;

@Repository
public class BookRepository implements CrudRepository<Book, Integer> {

	ArrayList<Book> books = new ArrayList<>();

	@Override
	public <S extends Book> S save(S book) {
		books.add(book);
		return book;
	}

	@Override
	public <S extends Book> Iterable<S> save(Iterable<S> entities) {

		return null;
	}

	@Override
	public Book findOne(Integer id) {
		return books.get(id);
	}

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public Iterable<Book> findAll() {
		return null;
	}

	@Override
	public Iterable<Book> findAll(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public void delete(Book entity) {

	}

	@Override
	public void delete(Iterable<? extends Book> entities) {

	}

	@Override
	public void deleteAll() {

	}

	public Boolean updateBook(Integer idBook, Book book) {
		
		try {

			Book prevBook = books.get(idBook);
			prevBook.setTitle(book.getTitle());
			prevBook.setPublishingHouse(book.getPublishingHouse());
			prevBook.setPageNumber(book.getPageNumber());
			prevBook.setYears(book.getYears());
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public Boolean addBook(Book book) {
		try {
			books.add(book);
			return true;
		} catch (Exception e) {
			return false;	
		}
	}

	public Boolean deleteBook(Integer idBook) {

		try {
			books.remove(books.get(idBook));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Book> getAllBook() {
		return books;
	}



}