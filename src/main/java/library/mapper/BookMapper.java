package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import library.entities.NewBook;

public interface BookMapper {

	@Select("Select * From books Where id = #{id}")
	public NewBook getBook(Integer id);

	@Select("Select * From books")
	public List<NewBook> getAllBook();
	
	@Insert("INSERT INTO books(title,publishingHouse,years,pageNumber) values (#{title},#{publishingHouse},#{years},#{pageNumber})")
	public Boolean addBook(NewBook books);

	@Update("Update books set title = #{title},publishingHouse = #{publishingHouse},years = #{years},pageNumber = #{pageNumber} Where id = #{id}")
	public Boolean updateBook(NewBook book);
	
	@Delete("Delete From books Where id = #{id}")
	public Boolean deleteBook(Integer id);
}
