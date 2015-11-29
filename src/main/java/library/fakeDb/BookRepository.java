package library.fakeDb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import library.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}