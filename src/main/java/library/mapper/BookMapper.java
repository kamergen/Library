package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import library.entities.Book;
import library.entities.BookInUse;

public interface BookMapper {

	@Select("Select * From books Where id = #{id}")
	public Book getBook(Integer id);

	@Select("Select books.id, title,author, publishingHouse, years, pageNumber From books Order by title Desc")
	public List<Book> getAllBook();
	
	@Insert("INSERT INTO books(title,author,publishingHouse,years,pageNumber) Values (#{title},#{author},#{publishingHouse},#{years},#{pageNumber})")
	public Boolean addBook(Book books);

	@Update("Update books Set title = #{title}, author = #{author}, publishingHouse = #{publishingHouse},years = #{years},pageNumber = #{pageNumber} Where id = #{id}")
	public Boolean updateBook(Book book);
	
	@Delete("Delete From books Where id = #{id}")
	public Boolean deleteBook(Integer id);

	@Select("Select * From books Join booksInUse On booksInUse.id_book=books.id join users On  booksInUse.id_user = users.id Where users.id=#{id}")
	public List<Book> getBooksUser(Integer id);
	
	@Select("Select * From booksInUse Where id_book = #{id}")
	public BookInUse getBookStatus(Integer id);
	
	@Select("Select * From books Where title = #{title} Or author = #{author}")
	public List<Book> bookSearch(Book book);
}
