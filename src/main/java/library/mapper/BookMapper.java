package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import library.entities.Book;

public interface BookMapper {

	@Select("Select * From books Where id = #{id}")
	public Book getBook(Integer id);

	@Select("Select books.id, title, publishingHouse, years, pageNumber, bookStatus.name From booksInUse Join bookStatus On booksInUse.bookStatus = bookStatus.id Join books On books.id = booksInUse.id_book")
	public List<Book> getAllBook();
	
	@Insert("INSERT INTO books(title,publishingHouse,years,pageNumber) values (#{title},#{publishingHouse},#{years},#{pageNumber})")
	public Boolean addBook(Book books);

	@Update("Update books set title = #{title},publishingHouse = #{publishingHouse},years = #{years},pageNumber = #{pageNumber} Where id = #{id}")
	public Boolean updateBook(Book book);
	
	@Delete("Delete From books Where id = #{id}")
	public Boolean deleteBook(Integer id);

	@Select("Select * From books join booksInUse on booksInUse.id_book=books.id join users on  booksInUse.id_user = users.id Where users.id=#{id}")
	public List<Book> getBooksUser(Integer id);
	
	@Select("Select   Where books.id = #{id} Group By name")
	public String getBookStatus(Integer id);
}
